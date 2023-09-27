package com.company.string.leetcode;

// https://leetcode.com/problems/count-and-say/description/
public class CountAndSay {
    public String countAndSay(int n) {
        // Recursive function to give us output.

        // Base case when our n == 1 we have to return "1".
        if(n == 1){
            return "1";
        }

        // We will make recursion call to "n - 1" and get the output of previous number.
        String prev = countAndSay(n - 1);

        // Count will be 1 at the starting because we are going to iterate the string from 1st index.
        int count = 1;

        // To store the current count and say string.
        // The answer will be created in the postorder because we need the previous result.
        // postorder means after all the previous recursion calls is completed till here.
        StringBuilder ans = new StringBuilder();

        // index
        int i = 1;


        while(i < prev.length()){

            // We have to compare previous and current characters of the string "prev"

            char prevChar = prev.charAt(i - 1);
            char currChar = prev.charAt(i);

            // When prevChar != currChar we have add it our answer first add the "count" and then add the "prevChar".
            if(prevChar != currChar){
                ans.append(count);
                ans.append(prevChar);

                // Reset the count.
                count = 1;
            } else {
                // Increement count if prevChar and currChar is equal.
                count++;
            }

            // Increement the index.
            i++;
        }

        // At the last when our iteration is over add the count and lastChar of the string "prev" to the answer.
        // because our while loop will run till last index and it can't able to compare the lastChar with the next char
        // Therefore the lastChar is not included in the answer.
        ans.append(count);
        ans.append(prev.charAt(prev.length() - 1));

        // return the answer.
        return ans.toString();
    }
}
