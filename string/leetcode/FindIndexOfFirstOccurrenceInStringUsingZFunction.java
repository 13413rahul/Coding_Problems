package com.company.string.leetcode;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class FindIndexOfFirstOccurrenceInStringUsingZFunction {
    public int strStr(String haystack, String needle) {
        String newString = needle + "$" + haystack;
        int[] z = ZAlog(newString);
        int tar = needle.length();
        //System.out.println(Arrays.toString(z));
        for(int i = 0; i<z.length ; i++){
            if(z[i] == tar){
                return i - (tar + 1);
            }
        }
        return -1;
    }

    public static int[] ZAlog(String st){
        int left = 0, right = 0;
        int [] arr = new int[st.length()];

        for(int k = 0; k<arr.length; k++){

            if(k > right){
                left = k;
                right = k;

                while(right < arr.length && st.charAt(right) == st.charAt(right - left)){
                    right++;
                }
                arr[k] = right - left;
                right--;
            }else{
                int k1 = k - left;
                if(arr[k1] < right - k + 1){
                    arr[k] = arr[k1];
                }else{
                    left = k;
                    while(right < arr.length && st.charAt(right) == st.charAt(right - left)){
                        right++;
                    }
                    arr[k] = right - left;
                    right--;
                }
            }
        }
        return arr;
    }
}
