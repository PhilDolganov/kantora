package com.javafortesters.chap021collectionsrevisited.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserComparator;
import com.javafortesters.domainentities.UserComparatorDisallowDupes;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Class21Examples {

    @Test
    public void sortedSetCanMaintainSortedOrder(){
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("a");
        alphaset.add("b");
        alphaset.add("a");

        assertEquals(4, alphaset.size());

        String[] alphas = new String[alphaset.size()];
        alphaset.toArray(alphas);

        assertEquals("a", alphas[0]);
        assertEquals("b", alphas[1]);
        assertEquals("c", alphas[2]);
        assertEquals("d", alphas[3]);
    }

    @Test
    public void canRetrieveFirstFromSortedSet(){
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        assertEquals("c", alphaset.first());

        alphaset.add("d");
        assertEquals("c", alphaset.first());

        alphaset.add("b");
        assertEquals("b", alphaset.first());

        alphaset.add("a");
        assertEquals("a", alphaset.first());
    }

    @Test
    public void canRetrieveLastFromSortedSet(){
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        assertEquals("c", alphaset.last());

        alphaset.add("b");
        assertEquals("c", alphaset.last());

        alphaset.add("d");
        assertEquals("d", alphaset.last());

        alphaset.add("a");
        assertEquals("d", alphaset.last());
    }

    @Test
    public void sortedSetCanReturnHeadSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.headSet("c");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("a", alphas[0]);
        assertEquals("b", alphas[1]);
    }

    @Test
    public void sortedSetCanReturnTailSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.tailSet("c");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("c", alphas[0]);
        assertEquals("d", alphas[1]);
    }

    @Test
    public void sortedSetCanReturnSubSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.subSet("b", "d");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("b", alphas[0]);
        assertEquals("c", alphas[1]);
    }

    @Test
    public void sortedSetWithComparatorForUser() throws InvalidPassword {
        User bob = new User("Bob", "pA55Word");  // 11
        User tiny = new User("TinyTim", "hello"); // 12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); //6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(sun.getUsername(), users[0].getUsername());
        assertEquals(bob.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(rich.getUsername(), users[4].getUsername());
    }

    @Test
    public void sortedSetWithComparatorForUserNoDupes() throws InvalidPassword {
        User bob = new User("Bob", "pA55Word"); // 11
        User dupebob = new User("Bob", "hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparatorDisallowDupes());

        userSortedList.add(bob);
        userSortedList.add(dupebob);
        userSortedList.add(rich);
        userSortedList.add(dupebob2);
        userSortedList.add(mrBeer);

        assertEquals(3, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(bob.getUsername(), users[0].getUsername());
        assertEquals(mrBeer.getUsername(), users[1].getUsername());
        assertEquals(rich.getUsername(), users[2].getUsername());

    }

    @Test
    public void sortedSetWithComparableUser() throws InvalidPassword {
        User bob = new User("Bob", "pA55Word"); // 11
        User dupebob = new User("Bob","hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>();

        userSortedList.add(bob);
        userSortedList.add(dupebob);
        userSortedList.add(rich);
        userSortedList.add(dupebob2);
        userSortedList.add(mrBeer);

        assertEquals(3, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(bob.getUsername(), users[0].getUsername());
        assertEquals(mrBeer.getUsername(), users[1].getUsername());
        assertEquals(rich.getUsername(), users[2].getUsername());
    }

    @Test
    public void sortedMap(){
        SortedMap<String,String> map = new TreeMap<>();

        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");
        map.put("key5", "value5");
        map.put("key4", "value4");

        assertEquals("key1", map.firstKey());
        assertEquals("key5", map.lastKey());

        SortedMap<String,String> headMap;
        headMap = map.headMap("key3");

        assertEquals(2, headMap.size());
        assertTrue(headMap.containsKey("key1"));
        assertTrue(headMap.containsKey("key2"));

        SortedMap<String,String> tailMap;
        tailMap = map.tailMap("key3");

        assertEquals(3, tailMap.size());
        assertTrue(tailMap.containsKey("key3"));
        assertTrue(tailMap.containsKey("key4"));
        assertTrue(tailMap.containsKey("key5"));

        SortedMap<String,String> subMap;
        subMap = map.subMap("key2", "key4");

        assertEquals(2, subMap.size());
        assertTrue(subMap.containsKey("key2"));
        assertTrue(subMap.containsKey("key3"));
    }

    @Test
    public void sortedMapWithComparatorForUser() throws InvalidPassword {
        User bob = new User("Bob", "pA55Word");  // 11
        User tiny = new User("TinyTim", "hello"); // 12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); //6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedMap<User,String> userSortedMap = new TreeMap<User,String>(new UserComparator());

        userSortedMap.put(bob, "Bob rules");
        userSortedMap.put(tiny, "Tiny Time");
        userSortedMap.put(rich, "Rich Richie");
        userSortedMap.put(sun, "Warfare Art");
        userSortedMap.put(mrBeer, "Cybernetician");

        User[] users = new User[userSortedMap.size()];
        userSortedMap.keySet().toArray(users);

        assertEquals(sun.getUsername(), users[0].getUsername());
        assertEquals(bob.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(rich.getUsername(), users[4].getUsername());

        Set<User> keys = userSortedMap.keySet();
        SortedSet<User> keys1 = new TreeSet<>(userSortedMap.keySet());
    }

    @Test
    public void exerciseCanGetAllKeysAsSortedSet(){
        Map<String,String> map = new HashMap<>();

        map.put("key4", "value4");
        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");

        SortedSet<String> keys = new TreeSet<>(map.keySet());

        int valSuffix = 1;
        for (String key : keys) {
            assertEquals("value" + valSuffix, map.get(key));
            valSuffix += 1;
        }
    }
}
