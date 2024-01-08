package com.algo.linkedlist.solutions;

public class RemovingDuplicates {
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head.next == null){
                return head;
            }

            ListNode current = head;
            while (current != null && current.next !=null){
                if (current.val == current.next.val){
                   current.next = current.next.next;

                } else {
                   current = current.next;
                }
            }

            return head;
        }

        public void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Test Example 0
            ListNode head0 = new ListNode(1);
            ListNode result0 = solution.deleteDuplicates(head0); // Expected: 1 -> 2
            solution.printList(result0);


            // Test Example 1
            ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
            ListNode result1 = solution.deleteDuplicates(head1); // Expected: 1 -> 2
            solution.printList(result1);

            // Test Example 2
            ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
            ListNode result2 = solution.deleteDuplicates(head2); // Expected: 1 -> 2 -> 3
            solution.printList(result2);

            // Test Example 3
            ListNode head3 = new ListNode(3, new ListNode(3, new ListNode(3)));
            ListNode result3 = solution.deleteDuplicates(head3); // Expected: 3
            solution.printList(result3);

            // Test Example 4
            ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(2, new ListNode(4)))));
            ListNode result4 = solution.deleteDuplicates(head4); // Expected: 1 -> 2 -> 4
            solution.printList(result4);

            // Test Example 5
            ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(2, new ListNode(4)))));
            ListNode result5 = solution.deleteDuplicates(head5); // Expected: 1 -> 2 -> 4 -> 5
            solution.printList(result5);
        }
    }
}
