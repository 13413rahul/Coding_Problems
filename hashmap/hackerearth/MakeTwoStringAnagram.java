package com.company.hashmap.hackerearth;

// https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/bob-and-string-easy/

/* IMPORTANT: Multiple classes and nested static classes are supported */

//import for Scanner and other utility classes

import java.util.*;

public class MakeTwoStringAnagram {

    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);

        // get n
        int n = Integer.parseInt(s.nextLine());

        // iterate through two lines at a time

        for (int i = 0; i < n; i++) {

            String strS = s.nextLine();
            String strT = s.nextLine();

            // init hashmaps for both strings S and T

            HashMap<Character, Integer> hashmapS = new HashMap<Character, Integer>(strS.length());

            HashMap<Character, Integer> hashmapT = new HashMap<Character, Integer>(strT.length());

            // iterate through each character in the strS and input counts into hashmapS
            for (int j=0; j<strS.length(); j++){

                Character c = new Character(strS.charAt(j));
                if (hashmapS.containsKey(c)) {
                    hashmapS.replace(c, hashmapS.get(c)+1);
                }
                else {
                    hashmapS.put(c, 1);
                }
            }

            // iterate through each character in the strT and input counts into hashmapT
            for (int j=0; j<strT.length(); j++){

                Character c = new Character(strT.charAt(j));
                if (hashmapT.containsKey(c)) {
                    hashmapT.replace(c, hashmapT.get(c)+1);
                }
                else {
                    hashmapT.put(c, 1);
                }
            }

            // sum up # of operations needed to ensure S and T match character for character
            int sum = 0;

            /* first iterate through hashmapS and find all operations of types:

            1. Key in hashmapS exists in T but there are more characters in S than T, so need

            to add each missing character to T.

            2. Key exists in T but there are more characters in T than S, so need to remove

            each extra character from T.

            3. Key does not exist in T, need to add each missing character to T

            */

            for (Character key: hashmapS.keySet()) {
                if (hashmapT.containsKey(key)) {
                    //this if block takes care of situation types #1 and #2 mentioned above.
                    sum += Math.abs(hashmapS.get(key) - hashmapT.get(key));
                }
                else {
                    // this else block takes care of situation #3 above.
                    sum += hashmapS.get(key);
                }
            }

            /* second iterate through hashmapT and find all operations of type:

            1. Key does not exist in S, need to remove each extra character in T.

            */

            for (Character key: hashmapT.keySet()) {
                if (!hashmapS.containsKey(key)) {
                    sum += hashmapT.get(key);
                }
            }

            // print resulting sum*2 which is the minimum number of operations required
            System.out.println(sum);

        }

    }

}
