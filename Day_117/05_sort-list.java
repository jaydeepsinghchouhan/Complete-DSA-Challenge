/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // find middle
        ListNode f = head, s = head;
        ListNode prev = null;

        while (f != null && f.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }

        prev.next = null;

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(s);

        return merge(leftHalf, rightHalf);
    }
    
	// 21. Merge Two Sorted Lists
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newNode.next = head1;
                head1 = head1.next;
            }
            else {
                newNode.next = head2;
                head2 = head2.next;
            }

            newNode = newNode.next;
        }

        while (head1 != null) {
            newNode.next = head1;
            head1 = head1.next;
            newNode = newNode.next;
        }

        while (head2 != null) {
            newNode.next = head2;
            head2 = head2.next;
            newNode = newNode.next;
        }

        return newHead.next;
    }
}