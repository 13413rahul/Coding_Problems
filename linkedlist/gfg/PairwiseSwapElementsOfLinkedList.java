package com.company.linkedlist.gfg;

// https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
public class PairwiseSwapElementsOfLinkedList {
    class Node {
        Node next;
        int val;
    }

    public Node pairwiseSwap(Node head)
    {
        // code here
        Node temp=null,prv=head,curr=head.next;
        while(curr!=null){
            prv.next=curr.next;
            curr.next=prv;
            if(temp!=null){
                temp.next=curr;
            }else{
                head=curr;
            }
            temp=prv;
            prv=prv.next;
            if(prv!=null){
                curr=prv.next;
            }else{
                curr=null;
            }
        }
        return head;
    }
}
