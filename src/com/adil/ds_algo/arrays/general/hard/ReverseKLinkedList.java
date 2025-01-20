package com.adil.ds_algo.arrays.general.hard;

public class ReverseKLinkedList {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode curr = head, prev = null, newHead = null, prevFirst = null, first = null;
        while(curr != null) {
            first = curr;
            if(validLength(curr, k)) {
                ListNode[] reverse = reverse(curr, k);
                prev = reverse[0];
                curr = reverse[1];
                if(newHead == null) newHead = prev;
                else prevFirst.next = prev;
            } else {
                prevFirst.next = curr;
                return newHead;
            }
            prevFirst = first;
        }
        return newHead;
    }

    // reversing recursively
    public ListNode[] reverse(ListNode head, int k) {
        if(head == null) return new ListNode[]{head, head};
        int count = 0;
        ListNode prev = null, curr = head, next  = null;

        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        return new ListNode[] {prev, curr};
    }

    public boolean validLength(ListNode head, int k) {
        if(head == null) return false;
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            curr = curr.next;
            count++;
            if(count == k) return true;
        }
        return false;
    }

    public void printLL(ListNode head) {
        if (head == null) return;
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
    }

}
