public class Palindrome {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(1);
        boolean result = isPalindrome(n);
        System.out.println(result);
        n = new Node(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(1);
        result = isPalindrome(n);
        System.out.println(result);
        n = new Node(0);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(1);
        result = isPalindrome(n);
        System.out.println(result);
    }
    /* Implement a function to check if a linked list is a palindrome */
    public static boolean isPalindrome(Node n) {
        Node trav = n;
        int count = 0;
        while (trav != null) {
            trav = trav.next;
            count++;
        }
        int middle = count / 2;
        Node sec = n;
        while (middle != 0) {
            sec = sec.next;
            middle--;
        }
        if (count % 2 == 1) {
            sec = sec.next;
        }
        middle = count /2 - 1;
        int track = middle;
        trav = n;
        while (sec != null) {
            while (track > 0) {
                trav = trav.next;
                track--;
            }
            if (trav.data != sec.data) {
                return false;
            }
            sec = sec.next;
            trav = n;
            middle--;
            track = middle;
        }
        return true;
    }
}
