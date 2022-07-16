import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static Node flattenLinkedList(Node root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        // Traverse the linked and add all the nodes to list
        while (root != null) {
            answer.add(root.data);
            Node temp = root;

            // Add all child nodes
            while (temp.child != null) {
                answer.add(temp.child.data);
                temp = temp.child;
            }
            root = root.next;
        }
        Collections.sort(answer);

        Node head = null;
        Node tail = null;

        // Create new linked list
        for (int i = 0; i < answer.size(); ++i) {
            Node newNode = new Node(answer.get(i));

            if (head == null) {
                head = newNode;
            } else {
                tail.child = newNode;
            }
            tail = newNode;
        }
        return head;
    }
}