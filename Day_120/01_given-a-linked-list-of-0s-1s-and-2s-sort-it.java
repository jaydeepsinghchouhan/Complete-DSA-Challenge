//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        if(head==null || head.next==null) return head;
        
        Node startP = head;
        Node endP = head;
        Node prev = null;
        int start = 0, end = 0;
        
        while(endP.next!=null) {
            endP = endP.next;
            end++;
        }
        
        while(start<=end) {
            if(startP.data==2) {
                if(prev==null) {
                    Node Next = startP.next;
                    head = Next;
                    startP.next = null;
                    endP.next = startP;
                    endP = endP.next;
                    startP = Next;
                }
                else {
                    Node Next = startP.next;
                    prev.next = Next;
                    startP.next = null;
                    endP.next = startP;
                    endP = endP.next;
                    startP = Next;
                }
            }
            else if(startP.data==0 && prev!=null) {
                Node Next = startP.next;
                prev.next = Next;
                startP.next = head;
                head = startP;
                startP = Next;
            }
            else {
                prev = startP;
                startP = startP.next;
            }
            start++;
        }
        return head;
    }
}


