public class Intersection {
    public static void main(String[] args) {
        Node n1 = new Node(0);
        n1.appendToTail(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(5);
        Node n2 = n1.next.next;
        Node result = intersection(n1, n2);
        System.out.println(result.data);
    }
    /* Given two linked lists, determine if the two lists intersect. Return the intersecting node */
    public static Node intersection(Node n1, Node n2) {
        Node trav = n1;
        int count1 = 0;
        while (trav != null) {
            count1++;
            trav = trav.next;
        }
        int count2 = 0;
        trav = n2;
        while (trav != null) {
            count2++;
            trav = trav.next;
        }
        Node small; Node big; int bigger; int smaller;
        if (count1 > count2) {
            small = n2;
            big = n1;
            bigger = count1;
            smaller = count2;
        }
        else {
            small = n1;
            big = n2;
            bigger = count2;
            smaller = count1;
        }
        while (bigger != smaller) {
            big = big.next;
            bigger--;
        }
        trav = big;
        int length = bigger;
        while (small != null) {
            while (length > 0) {
                if (trav == small) {
                    return trav;
                }
                trav = trav.next;
                length--;
            }
        }
        throw new IllegalArgumentException();
    }
}
