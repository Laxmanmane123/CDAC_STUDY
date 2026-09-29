package day1;

import java.security.Key;

public class Program4 {

    public static void main(String[] args) {
        // String s1 = "Sunbeam"; // literal pool
        // String s2 = "Sunbeam";
        // System.out.println(s1 == s2); // true, because both s1 and s2 refer to the
        // same string literal in the string
        // // pool
        // System.out.println(s1.equals(s2)); // true, because the contents of both
        // strings are the same

        // String s1 = new String("Sunbeam");
        // String s2 = new String("Sunbeam");
        // System.out.println(s1 == s2); // false, because s1 and s2 are two different
        // String objects created in the heap
        // System.out.println(s1.equals(s2)); // true, because the contents of both
        // strings are the same

        // String s1 = new String("Sunbeam"); // heap
        // String s2 = "Sun" + "beam";
        // System.out.println(s1 == s2); // why false, because s1 is a new String object
        // created in the heap, while s2 is a string literal that refers to the same
        // string in the string pool
        // System.out.println(s1.equals(s2)); // true, because the contents of both
        // strings are the same

        // heap compares references
        // literal pool compares contents
        // equals() compares contents

        // String s1 = "Sunbeam";
        // String s2 = "Sun";
        // String s3 = s2 + "beam"; // heap
        // System.out.println(s1 == s3); // false, because s1 is a string literal that
        // refers to the same string in the string pool, while s3 is a new String object
        // created in the heap
        // System.out.println(s1.equals(s3)); // true, because the contents of both
        // strings are the same

        // String s1 = "Sunbeam";
        // String s2 = new String("Sunbeam").intern(); // intern() method returns a
        // canonical representation for the string object. It returns a reference to the
        // string object from the string pool if it already exists, otherwise it adds
        // the string to the pool and returns a reference to it.
        // System.out.println(s1 == s2); // ???
        // System.out.println(s1.equals(s2)); // ???

        String s1 = "Sunbeam";
        String s2 = "SunBeam";
        System.out.println(s1 == s2); // ???
        System.out.println(s1.equals(s2)); // ???
        System.out.println(s1.equalsIgnoreCase(s2)); // ???
        System.out.println(s1.compareTo(s2)); // why -32, because the ASCII value of 'b' is 98 and the ASCII value of 'B' is 66, so 98 - 66 = 32
        System.out.println(s1.compareToIgnoreCase(s2)); // ???

        // Key Character Ranges (Memorize These)
        // Digits (0 to 9): Values 48 to 57
        // '0' = 48
        // '9' = 57
        // Uppercase Letters (A to Z): Values 65 to 90
        // 'A' = 65
        // 'Z' = 90
        // Lowercase Letters (a to z): Values 97 to 122
        // 'a' = 97
        // 'z' = 122

    }

}
