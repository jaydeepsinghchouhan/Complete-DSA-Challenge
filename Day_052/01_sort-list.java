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
        ListNode temp = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        temp.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1,l2);
    }
    
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) temp.next = l1;
        else if (l2 != null) temp.next = l2;
        return dummy.next;
    }
}