public class DeleteMiddle {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(5);
        n.appendToTail(3);
        Node c = n.next.next;
        deleteKth(c);
        Node trav = n;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }
    /* Implement an algorithm to delete a node in the middle (any node but the first and last node) of a singly linked
    list, given only access to that node

    Hint from book: how do you make it seem like it's gone?
    */
    public static void deleteKth(Node c) {
        c.data = c.next.data;
        c.next = c.next.next;
    }
}
