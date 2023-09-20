package com.company.linkedlist.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // when list1 is empty then
        // our output will be same as list2
        if(l1 == null) return l2;

        // when list2 is empty then our output
        // will be same as list1
        if(l2 == null) return l1;

        // pointing l1 and l2 to smallest and greatest one
        if(l1.val > l2.val) swap(l1,l2);

        // act as head of resultant merged list
        ListNode res = l1;

        while(l1 != null && l2 != null) {

            ListNode temp = null;

            while(l1 != null && l1.val <= l2.val) {

                temp = l1;//storing last sorted node
                l1 = l1.next;
            }

            // link previous sorted node with
            // next larger node in list2
            temp.next = l2;
            swap(l1,l2);
        }

        return res;
    }

    private void swap(ListNode l1, ListNode l2) {
        int t = l2.val;
        l2.val = l1.val;
        l1.val = t;
    }
}
