package com.company.hashmap.hackerearth;

import java.util.Scanner;

// https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/practice-problems/algorithm/shil-and-lucky-string-1/
public class CompareFirstHalfAndSecondHalf {

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int len=s.nextInt();
        String str=s.next();
        String first=str.substring(0,len/2);
        String second=str.substring(len/2);
        int w3=case3(first,second);
        int w2=case2(new StringBuilder(first),new StringBuilder(second));
        int w1=case2(new StringBuilder(second),new StringBuilder(first));
        int min=Math.min(w1,Math.min(w2,w3));
        System.out.println(min);
    }

    private static int case3(String a,String b)
    {
        int answer=a.length();
        int hash1[]=new int[26];
        int hash2[]=new int[26];
        for(int i=0;i<a.length();i++)
            hash1[a.charAt(i)-'a']++;
        for(int i=0;i<b.length();i++)
            hash2[b.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
            answer-=Math.min(hash1[i],hash2[i]);
        return answer;
    }

    static int case2(StringBuilder a,StringBuilder b)
    {
        int count=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='z')
            {
                a.replace(i,i+1,"a");
                count++;
            }
            if(b.charAt(i)=='a')
            {
                b.replace(i,i+1,"z");
                count++;
            }
        }
        int hash1[]=new int[26];
        for(int i=0;i<b.length();i++)
            hash1[b.charAt(i)-'a']++;
        for(int i=0;i<a.length();i++)
        {
            boolean found=false;
            for(int j=(a.charAt(i)-'a'+1);j<26;j++)
            {
                if(hash1[j]>0)
                {
                    hash1[j]--;
                    found=true;
                    break;
                }
            }
            if(found==false)
                count++;
        }
        return count;
    }

}
