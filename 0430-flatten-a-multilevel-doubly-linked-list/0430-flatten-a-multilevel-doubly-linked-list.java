/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    private Node recurrFlatten(Node head){
        Node curr = head;
        Node last = head; // will track the tail of the flattened list
        
        while(curr != null){
            Node next = curr.next;
            
            // If child exists, flatten it
            if(curr.child != null){
                Node childHead = recurrFlatten(curr.child);

                // Connect curr and childHead
                curr.next = childHead;
                childHead.prev = curr;

                // Find the tail of the child list
                Node childTail = childHead;
                while(childTail.next != null){
                    childTail = childTail.next;
                }

                // Connect childTail with next
                if(next != null){
                    childTail.next = next;
                    next.prev = childTail;
                }

                // clear child pointer
                curr.child = null;
                
                // move curr to tail
                last = childTail;
                curr = childTail;
            } else {
                last = curr;
                curr = next;
            }
        }
        return head;
    }

    public Node flatten(Node head) {
        if(head == null) return head;
        return recurrFlatten(head);
    }
}
