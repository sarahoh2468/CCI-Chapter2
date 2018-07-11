public class LoopDetection {
    public static void main(String[] args) {
        Node n1 = new Node(0);
        n1.appendToTail(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(5);
        Node n2 = n1.next.next;
        n2.next.next = n1;
        Node result = isLoop(n1);
        System.out.println(result.data);
    }
    /* Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop */
    public static Node isLoop(Node n) {
        Node trav = n;
        Node twice = n;
        while (twice != null) {
            trav = trav.next;
            twice = twice.next.next;
            if (trav == twice) {
                return trav;
            }
        }
        throw new IllegalArgumentException();
    }
}
