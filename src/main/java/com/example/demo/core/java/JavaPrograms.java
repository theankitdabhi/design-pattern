package com.example.demo.core.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class JavaPrograms {

    static void charFrequency() {
        String s = "Helooo";
        ArrayList<Character> chars = new ArrayList<>();
        char c = s.charAt(0);
        int count = 0;
        for (int index = 0; index < s.length(); index++) {
            if (!chars.contains(s.charAt(index))) {
                chars.add(s.charAt(index));
                int counter = 1;
                for (int sub = index + 1; sub < s.length(); sub++) {
                    if (s.charAt(index) != s.charAt(sub))
                        break;
                    counter++;
                }
                if (counter > count) {
                    count = counter;
                    c = s.charAt(index);
                }
            }
        }
        System.out.println(c + " : " + count);
    }

    static void eachCharOccurrance() {
        String test = "AAnkittt";
        Map<Character, Integer> characterIntegerHashMap = new HashMap<>();
        char[] chars = test.toCharArray();
        for (char aChar : chars) {
            if (characterIntegerHashMap.containsKey(aChar)) {
                Integer integer = characterIntegerHashMap.get(aChar);
                characterIntegerHashMap.put(aChar, ++integer);
            } else {
                characterIntegerHashMap.put(aChar, 1);
            }
        }
        System.out.println(characterIntegerHashMap);
    }

    public static void main(String[] args) {
        charFrequency();
        eachCharOccurrance();

        String panNumber = CustomConstant.PAN;
        boolean panMatches = validatePan(panNumber);
        if (panMatches) {
            System.out.println(CustomConstant.MSG_PAN_CORRECT);
        } else {
            System.out.println(CustomConstant.MSG_PAN_NOT_CORRECT);
        }

        //code riddle 1
        /*List<String> strings = Arrays.asList("I", "heckin'", "love", "java");
        List<String> list = new ArrayList<>(strings);
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                list.remove(i);
            }
        }
        System.out.println(list);*/

        //code riddle 2
        /*for (;;) {
            System.out.println("test");
        }*/

        //code riddle 3
        //compile time error
        //System.out.println("\u0022\u0029\u003B\u0077\u0068\u0069\u006C\u0065\u0028\u0074\u0072\u0075\u0065\u0029\u002F\u002F");
        // System.out.println("\u004D\u0061\u0067\u0069\u0063\u0021");

        //code riddle 4
        //will compile, but prints noting
        /*if (1 == 2) {
            System.out.println("1 is 2");
        }*/

        //will this program execute successfully
        //ClassCastException
/*
        Car car=new Car();
        car.setColour("White");
        car.setMilage(10);
        car.setTyres(4);
        car.setSeats(4);
        Vehicle cloneable = new Vehicle(car);
        Car cloneVehicle = (Car) cloneable.clone();
        System.out.println(cloneVehicle.toString());
*/

       /* String s1 = "foobar";
        String s2 = "foobar";
        System.out.println(s1 == s2);      // true
        s2 = new String("foobar");
        System.out.println(s1 == s2);      // false
        System.out.println(s1.equals(s2)); // true*/

    }

    private static boolean validatePan(String panNumber) {
        return Pattern.compile(CustomConstant.PAN_PATTERN).matcher(panNumber).matches();
    }
}
