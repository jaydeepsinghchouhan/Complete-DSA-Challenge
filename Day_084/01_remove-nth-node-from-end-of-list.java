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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        temp = head;
        int count = 0;
        while(size-n-1 != count){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }
}