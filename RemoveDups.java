public class RemoveDups {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(5);
        n.appendToTail(3);
        removeDups(n);
        Node trav = n;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }

    /* Write code to remove duplicates from an unsorted linked list */
    public static void removeDups(Node n) {
        Node trav = n;
        Node toDelete = trav.next;
        Node behind = trav;
        while (trav.next != null) {
            if (toDelete.data == trav.data) {
                behind.next = toDelete.next;
                trav = trav.next;
                toDelete = trav.next;
                behind = trav;
            }
            else if (toDelete.next == null) {
                trav = trav.next;
                toDelete = trav.next;
                behind = trav;
            }
            else {
                behind = toDelete;
                toDelete = toDelete.next;
            }

        }
    }
}
