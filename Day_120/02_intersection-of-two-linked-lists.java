/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        
        if(l1==null || l2==null) return null;
        ListNode a = l1;
        ListNode b = l2;
        while(a!=b) {
            a = a==null ? l2 : a.next;
            b = b==null ? l1 : b.next;
        }
        return a;
    }
}