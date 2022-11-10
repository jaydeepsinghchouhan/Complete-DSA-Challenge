/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null ) return head;
        if(head.next==null) {
            Node node=new Node(head.val);
            if(head.random==null)
                node.random=null;
            else
            node.random=node;
            node.next=null;
            return node;
        }
        Node node =head;
        while(node!=null) {
            Node t= new Node(node.val);
            t.next=node.next;
            node.next=t;
            node=node.next.next;
        }
        node=head;
        Node copy=node.next;
        while(node!=null) {
            if(node.random!=null)
            copy.random=node.random.next;
            node=node.next.next;
            if(copy.next!=null)
            copy=copy.next.next;
        }
        node=head;
        Node copyhead=node.next;
        copy=node.next;
        Node nexp=copy.next.next;
        while(copy!=null) {
            node.next=copy.next;
            copy.next=nexp;
            node=node.next;
            copy=copy.next;
            if(nexp!=null && nexp.next!=null)
            nexp=nexp.next.next;
            else
                nexp=null;
            
        }
        return copyhead;
    }
}