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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        Stack<ListNode> stack = new Stack<ListNode>();
        int i = 0;
        
        while(temp!=null){
            i++;
            stack.push(temp);
            if(i==k){
                ListNode top = stack.pop();
                ListNode nextElem = top.next;
                tail.next = top;
                while(!stack.isEmpty()){
                    ListNode elem = stack.pop();
                    top.next = elem;
                    top = elem;
                }
                tail = top;
                top.next = nextElem;
                temp = top;
                i=0;
            }

            temp = temp.next;
        }
        
        return dummy.next;
    }
}