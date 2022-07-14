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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != null) {
            h1 = h1.next;
            len1++;
        }
        while(h2 != null) {
            h2 = h2.next;
            len2++;
        }

        while(len1 != len2) {
            if (len1 > len2) {
                headA = headA.next;
                len1--;
            } else {
                headB = headB.next;
                len2--;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}