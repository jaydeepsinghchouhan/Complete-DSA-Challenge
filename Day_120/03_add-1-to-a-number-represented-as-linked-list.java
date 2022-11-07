//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 

    { 

        //code here.

        Node tt=head;

        Node revv=reverse(tt);

        Node rev=revv;

        Node prev=null;

        int carry=1;

        while(rev!=null)

        {

            int datt=rev.data+carry;

            rev.data=datt%10;

            carry=datt/10;

            prev=rev;

            rev=rev.next;

        }

        if(carry!=0)

        {

            prev.next=new Node(carry);

        }

        return reverse(revv);

    }

    public static Node reverse(Node head)

    {

        Node current=head;

        Node prev=null;

        Node next=null;

        while(current!=null)

        {

            next=current.next;

            current.next=prev;

            prev=current;

            current=next;

        }

        return prev;

 

    }
}
