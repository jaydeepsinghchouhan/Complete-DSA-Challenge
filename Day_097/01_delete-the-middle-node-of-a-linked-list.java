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
    public ListNode deleteMiddle(ListNode head) {
        // Base cases...
        if (head == null) return null;
        if (head.next == null) return null;
        // Initialize slow and fast pointers to reach middle of linked list...
        ListNode slow = head;
        ListNode fast = head;
        // Find the middle and previous of middle...
        ListNode prev = null;
        // To store previous of slow pointer...
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // Delete the middle node...
        prev.next = slow.next;
        return head;
    }
}