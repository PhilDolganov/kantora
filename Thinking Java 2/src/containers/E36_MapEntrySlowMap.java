package containers;

// {Args: 100 5000} Small to keep build testing short

import java.util.*;

// Does not support 'null' keys.
@SuppressWarnings("unchecked")
class MapEntrySlowMap1<K,V> extends AbstractMap<K,V> {
    protected List<MapEntry<K,V>> entries = new ArrayList<>();
    // Returns the entry matching the specified key, or null.
    protected MapEntry<K,V> getEntry(Object key){
        for (MapEntry<K,V> entry : entries)
            if (entry.getKey().equals(key))
                return entry;
            return null;
    }
    @Override public V put(K key, V value){
        if (key == null)
            throw new NullPointerException();
        MapEntry<K,V> oldEntry = getEntry(key);
        V oldValue = null;

        if (oldEntry == null)
            entries.add(new MapEntry<>(key, value));
        else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return oldValue;
    }
    @Override public V get(Object key){
        if (key == null)
            throw new NullPointerException();
        MapEntry<K,V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }
    private EntrySet entrySet = new EntrySet();
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }
    // Uses the 'Flyweight' pattern
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<>() {
                private int index =  -1;
                boolean canRemove;
                @Override
                public boolean hasNext() {
                    return index < entries.size() - 1;
                }

                @Override
                public Map.Entry<K, V> next() {
                    canRemove = true;
                    ++index;
                    return entries.get(index);
                }

                @Override
                public void remove() {
                    if (!canRemove) throw new IllegalStateException();
                    canRemove = false;
                    entries.remove(index--);
                }
            };
        }
        @Override
        public boolean contains(Object o){
            if (o instanceof MapEntry){
                MapEntry<K,V> e = (MapEntry<K, V>)o;
                return e.equals(getEntry(e.getKey()));
            }
            return false;
        }
        @Override
        public boolean remove(Object o){
            if (contains(o)){
                entries.remove(o);
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return entries.size();
        }
        @Override
        public void clear(){
            entries.clear();
        }
    }
}
@SuppressWarnings("unchecked")
class MapEntryComp<K,V> implements Comparator<MapEntry<K,V>>{
    public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
        Comparable<K> c1 = (Comparable<K>)o1.getKey();
        return c1.compareTo(o2.getKey());
    }
}
@SuppressWarnings("unchecked")
class MapEntrySlowMap2<K,V> extends MapEntrySlowMap1<K,V> {
    final MapEntryComp<K,V> comp = new MapEntryComp<>();
    // Returns the entry matching the specified key, or null.
    @Override
    protected MapEntry<K,V> getEntry(Object key){
        MapEntry<K,V> searchEntry = new MapEntry<>((K)key,null);
        int index = Collections.binarySearch(entries, searchEntry, comp);
        if (index >= 0)
            return entries.get(index);
        return null;
    }
    @Override
    public V put(K key, V value){
        if (key == null) throw new NullPointerException();
        MapEntry<K,V> oldEntry = getEntry(key);
        V oldValue = null;
        if (oldEntry == null){
            entries.add(new MapEntry<K,V>(key,value));
            Collections.sort(entries, comp);
        } else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return oldValue;
    }
}
public class E36_MapEntrySlowMap {
    public static void main(String[] args) {
        // Testing correctness...
        System.out.println("Testing MapEntrySlowMap1");
        E16_SlowMapTest.test(new MapEntrySlowMap1<>());
        System.out.println("Testing MapEntrySlowMap2");
        E16_SlowMapTest.test(new MapEntrySlowMap2<>());
        // Measuring performance...
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.run(new TreeMap<>(), E35_MapPerformance2.tests);
        Tester.run(new HashMap<>(), E35_MapPerformance2.tests);
        Tester.run(new LinkedHashMap<>(), E35_MapPerformance2.tests);
        Tester.run(new IdentityHashMap<>(), E35_MapPerformance2.tests);
        Tester.run(new WeakHashMap<>(), E35_MapPerformance2.tests);
        Tester.run(new Hashtable<>(), E35_MapPerformance2.tests);
        Tester.run(new SlowMap2<>(), E35_MapPerformance2.tests);
        Tester.run(new MapEntrySlowMap1<>(), E35_MapPerformance2.tests);
        Tester.run(new MapEntrySlowMap2<>(), E35_MapPerformance2.tests);
    }

}
