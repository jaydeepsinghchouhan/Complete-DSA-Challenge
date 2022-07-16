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
    public boolean isPalindrome(ListNode head) {
        //Find the middle Node
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //Reverse the list from mid to end
        ListNode mhead = null;
        while(slow!=null){
            ListNode node = new ListNode(slow.val);
            node.next = mhead;
            mhead=node;
            slow=slow.next;
        }
        //Check if values are matching or not
        while(mhead!=null){
            if(mhead.val!=head.val)
                return false;
            head=head.next;
            mhead=mhead.next;
        }
        return true;
    }
}