public class ReturnLast {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(5);
        n.appendToTail(3);
        int result = returnKth(n, 2);
        System.out.println(result);
    }
    /* Implement an algorithm to find the kth to last element of a singly linked list */
    public static int returnKth(Node n, int k) {
        int count = 1;
        Node trav = n;
        while (trav.next != null) {
            trav = trav.next;
            count+=1;
        }
        int iter = count - k;
        trav = n;
        while (iter != 0) {
            trav = trav.next;
            iter-= 1;
        }
        return trav.data;
    }
}
