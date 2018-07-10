public class Partition {
    public static void main(String[] args) {
        Node n = new Node(6);
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(1);
        n.appendToTail(5);
        n = partition(n, 3);
        Node trav = n;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }
    /* Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
    greater or equal to x. If x is contained within the list, the values of x only need to be after the elements less
    than x. The partition element x can appear anywhere in the "right partition"
    */
    public static Node partition(Node n, int x) {
        Node trav = n;
        Node trail = n;
        while (trav != null) {
            if (trav.data < x) {
                trail.next = trav.next;
                trav.next = n;
                n = trav;
                trav = trail.next;
            }
            else {
                trail = trav;
                trav = trav.next;
            }
        }
        return n;
    }
}
