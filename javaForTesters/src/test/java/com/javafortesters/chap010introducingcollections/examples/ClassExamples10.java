package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ClassExamples10 {

    @Test
    public void simpleArrayExample(){
        String[] numbers0123 = {"zero","one","two","three"};
        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }
        assertEquals("zero", numbers0123[0]);
        assertEquals("three", numbers0123[3]);
    }

    @Test
    public void simpleCollectionExample(){
        String[] numbers0123Array = {"zero","one","two","three"};
        List<String> numbers0123 = Arrays.asList(numbers0123Array);
        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }
        assertEquals("zero", numbers0123.get(0));
        assertEquals("three", numbers0123.get(3));
    }

    @Test
    public void simpleDynamicCollectionExample(){
        List<String> numbers0123 = new ArrayList<String>();
        numbers0123.add("zero");
        numbers0123.add("one");
        numbers0123.add("two");
        numbers0123.add("three");

        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }
        assertEquals("zero", numbers0123.get(0));
        assertEquals("three", numbers0123.get(3));
    }

    Collection<String> workdays = new ArrayList<>();
    Collection<String> daysOfWeek = new ArrayList<>();
    Collection<String> weekendDays = new ArrayList<>();
    //String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    //String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    //String[] weekendDays = {"Saturday", "Sunday"};

    @Test
    public void addElementsToCollection(){

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        assertEquals(5, workdays.size());
    }

    @Test
    public void addAll(){
        daysOfWeek.addAll(workdays);

        assertEquals(workdays.size(), daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(workdays));
    }

    @Test
    public void removingIndividualElements(){
        weekendDays.add("Saturday");
        weekendDays.add("Funday");
        weekendDays.remove("Funday");

        assertFalse(weekendDays.contains("Funday"));

        weekendDays.add("Sunday");

        assertEquals(2, weekendDays.size());
        assertTrue("Bug Fixed, Sunday is in the collection now", weekendDays.contains("Sunday"));
    }

    @Test
    public void iterateOverCollection(){

        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        for (String dayOfWeek : daysOfWeek) {
            System.out.println(dayOfWeek);
        }
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        for (Object workday : workdays) {
            String outputDay = (String) workday;
            System.out.println(outputDay);
        }

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        Collection<String> daysOfWeek = new ArrayList<>();
        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(7, daysOfWeek.size());
        daysOfWeek.clear();

        assertEquals(0, daysOfWeek.size());
        assertTrue(daysOfWeek.isEmpty());
    }

    @Test
    public void removeAllOfOneCollectionFromAnother(){
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");
        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        Collection<String> daysOfWeek = new <String>ArrayList();

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(7, daysOfWeek.size());

        daysOfWeek.removeAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertEquals(5, daysOfWeek.size());
        assertFalse(daysOfWeek.contains(weekendDays));
    }

    @Test
    public void removeAllButOneCollectionFromAnother(){
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");
        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        Collection<String> daysOfWeek = new ArrayList<>();

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertTrue(daysOfWeek.containsAll(weekendDays));

        daysOfWeek.retainAll(weekendDays);

        assertEquals("only weekend days now", 2, daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(weekendDays));
        assertFalse(daysOfWeek.containsAll(workdays));
    }

    @Test
    public void convertCollectionToArray(){
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        Object[] daysOfWeekArray = daysOfWeek.toArray();
        assertEquals(7, daysOfWeekArray.length);

        assertEquals("Monday".length(), ((String)daysOfWeekArray[0]).length());

        String[] anotherArray = new String[daysOfWeek.size()];
        daysOfWeek.toArray(anotherArray);
        assertEquals("Monday".length(), anotherArray[0].length());
    }

    @Test
    public void createAndManipulateACollectionOfUsers() throws InvalidPassword {
        Collection<User> someUsers = new ArrayList<User>();

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        assertEquals(0, someUsers.size());
        assertTrue(someUsers.isEmpty());

        someUsers.add(bob);
        someUsers.add(eris);

        assertEquals(2, someUsers.size());
        assertFalse(someUsers.isEmpty());

        Collection<User> secondUsers = new ArrayList<User>();
        User robert = new User("robert", "9assword");
        User aleister = new User("aleister", "Pass5word");

        secondUsers.add(robert);
        secondUsers.add(aleister);
        assertEquals(2, secondUsers.size());

        someUsers.addAll(secondUsers);
        assertEquals(4, someUsers.size());
        assertTrue(someUsers.containsAll(secondUsers));
        assertTrue(someUsers.contains(aleister));

        secondUsers.removeAll(someUsers);
        assertEquals(0, secondUsers.size());

        someUsers.clear();
        assertEquals(0, someUsers.size());
    }

    @Test
    public void getAnElementAtAnIndex(){
        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void removeAnElementAtAnIndex(){
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        days.remove(1);

        assertEquals(2, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Wednesday", days.get(1));

    }

    @Test
    public void elementAtASpecificIndex(){
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        days.add(0,"Monday");
        days.add(2, "Wednesday");
        days.add(4, "Friday");
        days.add(6, "Sunday");
    }

    @Test
    public void addAllElementsInACollection(){
        List<String> days = new ArrayList<>();
        List<String> missingDays = new ArrayList<>();

        days.add("Monday");
        days.add("Friday");

        missingDays.add("Tuesday");
        missingDays.add("Wednesday");
        missingDays.add("Thursday");

        days.addAll(1, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void findTheIndexOfAnElement(){
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        assertEquals(1, days.indexOf("Thursday"));
    }

    @Test
    public void lastIndexOfAnElement(){
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");
        days.add("Thursday");
        days.add("Thursday");
        days.add("Sunday");

        assertEquals(4, days.lastIndexOf("Thursday"));
    }

    @Test
    public void setAnElementAtAnIndex(){
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Thursday");
        days.add("Wednesday");

        days.set(1, "Tuesday");

        assertEquals("Tuesday", days.get(1));
        assertEquals(3, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void sublistToCreateAPortionOfTheList(){
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        List<String> workdays = days.subList(0, 5);

        assertEquals(5, workdays.size());
        assertEquals("Monday", workdays.get(0));
        assertEquals("Tuesday", workdays.get(1));
        assertEquals("Wednesday", workdays.get(2));
        assertEquals("Thursday", workdays.get(3));
        assertEquals("Friday", workdays.get(4));
    }

    @Test
    public void testUserList() throws InvalidPassword {
        List<User> aUser = new ArrayList<>();

        assertEquals(0, aUser.size());

        User peter = new User("Peter", "Pazzword");
        User john = new User("John", "Passwd");
        aUser.add(peter);

        assertEquals(1, aUser.size());
        assertEquals("Peter", aUser.get(0).getUsername());
        assertEquals("Pazzword", aUser.get(0).getPassword());

        aUser.add(0, john);

        assertEquals(2, aUser.size());
        assertEquals("John", aUser.get(0).getUsername());
        assertEquals("Peter", aUser.get(1).getUsername());
        assertEquals(0, aUser.indexOf(john));
        assertEquals(1, aUser.indexOf(peter));

        aUser.remove(0);

        assertEquals(1, aUser.size());
        assertEquals(0, aUser.indexOf(peter));
    }

    @Test
    public void setDoesNotAllowDuplicateElements(){
        Set workdays = new HashSet();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        assertEquals(1, workdays.size());
    }

    @Test
    public void createAndManipulateASetOfUsers() throws InvalidPassword {
        Set<User> users = new HashSet<User>();

        assertEquals(0, users.size());

        User bob = new User("Bob", "Pazzword");
        users.add(bob);

        assertEquals(1, users.size());
        assertTrue(users.contains(bob));

        users.add(bob);

        assertEquals(1, users.size());
        assertFalse(users.size() == 2);
    }

    @Test
    public void useOfMap(){
            Map<String,User> mapa = new HashMap<>();
            Map<String,User> mapb = new HashMap<String, User>();
            Map<String,User> mapc = new <String,User>HashMap();

            assertEquals(0, mapa.size());
        }

    @Test
    public void putKeyValue(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.put("key1", "newvalue1");
        assertEquals("newvalue1", map.get("key1"));
    }

    @Test
    public void retrieveValueFromTheMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));

        assertEquals(null, map.get("key4"));

        map.remove("key1");
        assertEquals(2, map.size());

        map.clear();
        assertEquals(0,map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void checkContentsOfMap(){
        Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key23"));

        assertTrue(map.containsValue("value2"));
        assertFalse(map.containsValue("value23"));

        Map<String,String> mapToAdd = new HashMap<>();
        mapToAdd.put("key1", "keyvalue1");
        mapToAdd.put("key4", "value4");

        map.putAll(mapToAdd);

        assertEquals(4, map.size());
        assertEquals("keyvalue1", map.get("key1"));

        Collection<String> values = map.values();

        Set<String> keys = map.keySet();

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry :
                entries) {
            entry.setValue("bob");
        }
    }

    @Test
    public void createAndManipulateAMapOfUserObjects() throws InvalidPassword {
        Map<String,User> userMap = new HashMap<>();

        assertTrue(userMap.isEmpty());
        assertEquals(0, userMap.size());

        User bob = new User("bob", "PasswoRd");
        User john = new User("john", "Pazzword");

        userMap.put(bob.getUsername(), bob);
        assertEquals(1, userMap.size());

        userMap.put(bob.getUsername(), john);
        assertEquals(1, userMap.size());
        assertEquals(john, userMap.get("bob"));
    }
}
