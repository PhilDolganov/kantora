package runtimepractice;

import java.util.HashMap;

public class RuntimePractice {

    public static int findNumsOfRepetitions(String s, char c){
        // Linear time; O(n) time
        int sum = 0; // 1
        for (int i = 0; i < s.length(); i++) { // 1, n+1, n
            if (s.charAt(i) == c){ // n
                sum++; // n
            }
        }
        return sum;
    }

    public static int[] findNumsOfRepetitionsv1(String s, char[] c){
        // Quad time: O(n * m) time
        int[] sums = new int[c.length]; //1
        for (int i = 0; i < s.length(); i++) {// 1, n + 1, n
            for (int j = 0; j < c.length; j++) {// n, n*m + 1, n*m
                    if (s.charAt(i) == c[j]){// n * m
                        sums[j] += 1; // n * m
                    }
            }
        }
        return sums; //1
    }

    public static int[] findNumsOfRepetitionsv2(String s, char[] c){
        // Optimal time: O(n)
        int[] sums = new int[c.length]; //1
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                int sum = map.get(s.charAt(i));
                map.put(s.charAt(i), sum+1);
            }
        }
        for (int j = 0; j < c.length; j++) {
            int sum;
            if (!map.containsKey(c[j])){
                sums[j] = 0;
            } else {
                sums[j] = map.get(c[j]);
            }
        }
        return sums;
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitions("aSDHlsndlDJndwnjwndjwndnwqndwqndjwbdjwbdqkbwdkjbkjwbdkjwbdkjqbdkqwbdkjqwbdkqbcakjndcLSCnsc;N'QWCJq'j",'a'));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Test " + duration + "ms");

        char[] a = {'a','b','c','d','e','f','g','h','i','j','k'};

        startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitionsv1("aSDHlsndlDJndwnjwndjwndnwqndwqndjwbdjwbdqkbwdkjbkjwbdkjwbdkjqbdkqwbdkjqwbdkqbcakjndcLSCnsc;N'QWCJq'j",a));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Test " + duration + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitionsv2("aSDHlsndlDJndwnjwndjwndnwqndwqndjwbdjwbdqkbwdkjbkjwbdkjwbdkjqbdkqwbdkjqwbdkqbcakjndcLSCnsc;N'QWCJq'j",a));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Test " + duration + "ms");
    }
}
