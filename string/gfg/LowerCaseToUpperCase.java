package com.company.string.gfg;

// https://practice.geeksforgeeks.org/contest/job-a-thon-hiring-challenge-experienced-professionals/problems
public class LowerCaseToUpperCase {
    public static String LowerToUpper(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                i++;
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
