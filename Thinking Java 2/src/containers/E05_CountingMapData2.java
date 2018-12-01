package containers;

import java.util.*;

class CountingMapData extends AbstractMap<Integer,String> {

    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if (size < 0) this.size = 0;
            this.size = size;
    }

    private class Entry implements Map.Entry<Integer,String>{
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Entry && index == ((Entry)o).index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
    private class Iter implements Iterator<Map.Entry<Integer,String>> {
        private Entry entry = new Entry(-1);
        @Override
        public boolean hasNext() {
            return entry.index < size - 1;
        }
        @Override
        public Map.Entry<Integer, String> next() {
            entry.index++;
            return entry;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Map.Entry<Integer, String>> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return 0;
    }
}
    private Set<Map.Entry<Integer,String>> entries = new EntrySet();

    public Set<Map.Entry<Integer, String>> entrySet() {
        return entries;
    }
}
public class E05_CountingMapData2 {
    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
