package com.javafortesters.chap017datesandtimes.examples;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassExamples17 {
    @Test
    public void currentTimeMillis(){
        long startTime = System.currentTimeMillis();

        for (int x = 0; x < 10; x++) {
            System.out.println("Current Time " + System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void currentNanoTime(){
        long startTime = System.nanoTime();

        for (int x = 0; x < 10; x++) {
            System.out.println("Current Time " + System.nanoTime());
        }
        long endTime = System.nanoTime();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void createAUniqueUserIDAllChars(){
        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println(initialUserID);

        String userID = initialUserID;
        for (int x = 0; x < 10; x++) {
            String charReplacement = "" + ((char)('A' + x));
            String intToReplace = String.valueOf(x);
            userID = userID.replace(intToReplace, charReplacement);
        }
        assertThat(userID.contains("0"), is(false));
        assertThat(userID.contains("1"), is(false));
        assertThat(userID.contains("2"), is(false));
        assertThat(userID.contains("3"), is(false));
        assertThat(userID.contains("4"), is(false));
        assertThat(userID.contains("5"), is(false));
        assertThat(userID.contains("6"), is(false));
        assertThat(userID.contains("7"), is(false));
        assertThat(userID.contains("8"), is(false));
        assertThat(userID.contains("9"), is(false));

        assertThat(initialUserID.length(), is(userID.length()));

        System.out.println(userID);
    }

    @Test
    public void dateTime(){
        Date equivDate1 = new Date();
        Date equivDate2 = new Date(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.toString());

        long oneWeekFromNowTime = date.getTime();
        oneWeekFromNowTime += (1000 * 60 * 60 * 24 * 7);
        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNow.toString());

        Date sameDate = new Date();
        sameDate.setTime(date.getTime());
        assertThat(date.equals(sameDate), is(true));
        assertThat(date.compareTo(sameDate), is(0));
    }

    @Test
    public void simpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date(1000 * 60 * 60 * 24);
        sdf.applyPattern("MM/dd/yyyy");
        assertThat(sdf.format(date), is("01/01/1970"));

        SimpleDateFormat sdf1 = new SimpleDateFormat("y M d HH:mm:ss.SSS");
        Date date1 = sdf1.parse("2013 12 15 23:39:54.123");
        System.out.println(date1);
    }

    @Test
    public void calendar(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime().getTime());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void writeCalendarToStringToConsole(){
        Calendar cal = Calendar.getInstance();
     System.out.println(cal.toString());
    }

    @Test
    public void setTime(){
        Calendar cal = Calendar.getInstance();
        Calendar sameDate = Calendar.getInstance();
        sameDate.setTime(cal.getTime());
        assertThat(cal.equals(sameDate), is(true));
        assertThat(cal.compareTo(sameDate), is(0));

        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.setTime(cal.getTime());
        oneWeekFromNow.add(Calendar.DATE, 7);

        assertThat(oneWeekFromNow.after(cal), is(true));
        assertThat(cal.before(oneWeekFromNow), is(true));
        assertThat(cal.compareTo(oneWeekFromNow), is(-1));
        assertThat(oneWeekFromNow.compareTo(cal), is(1));

        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, 11); // starts at 0
        cal.set(Calendar.DAY_OF_MONTH, 15);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 39);
        cal.set(Calendar.SECOND, 54);
        cal.set(Calendar.MILLISECOND, 123);

        System.out.println(cal.getTime());

        cal.set(Calendar.MONTH, Calendar.DECEMBER);
    }

    @Test
    public void setTheCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 11, 15);
        cal.set(2013, Calendar.DECEMBER, 15);
        cal.set(2013, 11, 15, 23, 39);
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.setTime(new Date(0L));
        cal.setTimeInMillis(0L);
        cal.setWeekDate(2013, 3, Calendar.THURSDAY);
        System.out.println(cal.getTime());
    }

    @Test
    public void detailsFromCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
    }

    @Test
    public void useOtherCalendarConstants(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,49, 54);
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.YEAR), is(2013));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(15));
        assertThat(cal.get(Calendar.HOUR_OF_DAY), is(23));
        assertThat(cal.get(Calendar.MINUTE), is(49));
        assertThat(cal.get(Calendar.HOUR), is(11));
        assertThat(cal.get(Calendar.AM_PM), is(Calendar.PM));
    }

    @Test
    public void experimentWithOtherConstants(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);

        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(Calendar.SUNDAY));
        assertThat(cal.get(Calendar.DAY_OF_YEAR), is(349));

        // week of month depends on first day of week
        // some places use SUNDAY as first day
        // set to MONDAY for our calculation
        // and control Minimal Days in First Week
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(6);
        assertThat(cal.get(Calendar.WEEK_OF_MONTH), is(2));
        // Week of the year, similarly requires the
        // config to control first day
        assertThat(cal.get(Calendar.WEEK_OF_YEAR), is(50));
    }

    @Test
    public void addAndSubtractToRollDatesThroughTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);
        cal.add(Calendar.HOUR_OF_DAY, -1);
        assertThat(cal.get(Calendar.HOUR_OF_DAY), is(22));
        cal.add(Calendar.MINUTE,10);
        assertThat(cal.get(Calendar.MINUTE), is(49));
    }

    @Test
    public void incrementAndDecrementOtherFields(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);
        cal.add(Calendar.YEAR,-2);
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_MONTH, -12);

        assertThat(cal.get(Calendar.YEAR), is(2011));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(3));

        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);

        // bump it forward to 3rd June 2014,
        // then pull it back
        cal.add(Calendar.DAY_OF_MONTH, 19);
        cal.add(Calendar.MONTH, 5);
        cal.add(Calendar.YEAR, -3);

        assertThat(cal.get(Calendar.YEAR), is(2011));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(3));

        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);
        cal.roll(Calendar.DAY_OF_MONTH, 17);
        assertThat(cal.get(Calendar.YEAR), is(2013));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(1));
    }

    @Test
    public void rollCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);

        cal.roll(Calendar.DAY_OF_MONTH, 17);

        assertThat(cal.get(Calendar.YEAR), is(2013));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(1));

        cal.set(2013,Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.DAY_OF_MONTH, 17);
        assertThat(cal.get(Calendar.YEAR), is(2014));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JANUARY));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(1));
    }
}
