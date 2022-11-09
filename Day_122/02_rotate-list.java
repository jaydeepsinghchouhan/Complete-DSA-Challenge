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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null) return head;
        
        ListNode temp = head;
        ListNode curr = temp, next = curr.next;
        
        int n=1;
        while(curr.next != null) {
            curr = curr.next;
            n++;
        }
        k=k%n;
        if(k%n==0) return head;
        for(int i=1; i<n; i++) {
            if(i==n-k) {
                curr = temp;
                next = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;
        temp.next = head;
        head = next;
        
        return head;
    }
}