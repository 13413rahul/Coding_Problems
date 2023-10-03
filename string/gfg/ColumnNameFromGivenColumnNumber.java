package com.company.string.gfg;

// https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1
public class ColumnNameFromGivenColumnNumber {
    String colName (long n)
    {
        String op = "";
        // your code here
        if (n <= 26){
            op = Character.toString((char)(64+n));
        }
        else{
            StringBuilder str = new StringBuilder();
            while (n > 0){
                n--;
                char ch = (char)('A' + n%26);
                str.insert(0,ch);
                n/=26;
            }
            op = str.toString();
        }
        return op;
    }
}
