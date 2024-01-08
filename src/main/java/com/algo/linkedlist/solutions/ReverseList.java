package com.algo.linkedlist.solutions;

public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode reverseNode = null;
            ListNode current = head;

            while (current != null){
               ListNode next = current.next;
               current.next = reverseNode;
               reverseNode = current;
               current = next;
            }

            return reverseNode;
        }

        public void printReverse(ListNode head){
            ListNode reverseList = reverseList(head);

            while (reverseList != null) {
                System.out.println(reverseList.val);
                reverseList = reverseList.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ReverseList.ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        node.next.next = new ListNode(2);

        solution.printReverse(node);
    }
}
