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
    
    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null) {
            next=head.next;
            head.next=pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head.next==null || head==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = reverseList(slow.next);
        
        slow = slow.next;
        while(slow!=null) {
            if(head.val!=slow.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}