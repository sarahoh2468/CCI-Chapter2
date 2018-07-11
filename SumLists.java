public class SumLists {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        n1.appendToTail(1);
        n1.appendToTail(6);
        Node n2 = new Node(5);
        n2.appendToTail(9);
        n2.appendToTail(2);
        Node result = sumListsReverse(n1, n2);
        Node trav = result;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
        Node n3 = new Node(6);
        n3.appendToTail(1);
        n3.appendToTail(7);
        Node n4 = new Node(2);
        n4.appendToTail(9);
        n4.appendToTail(5);
        result = sumListsForward(n3, n4);
        trav = result;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }

        // Input: 7 - 1 - 6 + 5 - 9 - 2 Output: 2 - 1 - 9
        //Input: 6 - 1- 7 + 2 - 9- 5 Output: 9 - 1 - 2
    }
    /* You have two numbers represented by a linked list, where each node contains a single digit. The digits are
    stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the
    two numbers and returns the sum as a linked list. Write function with forward order
     */
    public static Node sumListsReverse(Node n1, Node n2) {
        Node trav = n1;
        int num1 = 0;
        int num2 = 0;
        int sum;
        int tens;
        int tens1 = 1;
        while (trav != null) {
            num1 += trav.data * tens1;
            tens1 *= 10;
            trav = trav.next;
        }
        trav = n2;
        int tens2 = 1;
        while (trav != null) {
            num2 += trav.data * tens2;
            tens2 *= 10;
            trav = trav.next;
        }
        sum = num1 + num2;
        if (tens1 > tens2) {
            tens = tens1;
        }
        else {
            tens = tens2;
        }
        if ((sum / tens) < 1) {
            tens /= 10;
        }
        int value = sum / tens;
        Node left = new Node(value);
        trav = left;
        sum -= value*tens;
        tens /= 10;
        while (sum >= 1) {
            value = sum / tens;
            Node new_node = new Node(value);
            trav = new_node;
            trav.next = left;
            left = new_node;
            sum -= value*tens;
            tens /= 10;
        }
        return trav;
    }

    public static Node sumListsForward(Node n1, Node n2) {
        int count1 = 0;
        Node trav = n1;
        while (trav.next != null) {
            count1 += 1;
            trav = trav.next;
        }
        int count2 = 0;
        trav = n2;
        while (trav.next != null) {
            count2 += 1;
            trav = trav.next;
        }
        if (count1 > count2) {
            Node left = n2;
            while (count1 != count2) {
                Node new_node = new Node(0);
                trav = new_node;
                trav.next = left;
                left = new_node;
                count2++;
            }
        }
        else if (count1 < count2) {
            Node left = n1;
            while (count1 != count2) {
                Node new_node = new Node(0);
                trav = new_node;
                trav.next = left;
                left = new_node;
                count1++;
            }
        }
        int tens = 1;
        while (count1 != 0) {
            tens *= 10;
            count1--;
        }
        int reset = tens;
        int num1 = 0;
        int num2 = 0;
        trav = n1;
        while (trav != null) {
            num1 += reset*trav.data;
            reset /= 10;
            trav = trav.next;
        }
        trav = n2;
        reset = tens;
        while (trav != null) {
            num2 += reset*trav.data;
            reset /= 10;
            trav = trav.next;
        }

        int sum = num1 + num2;
        reset = tens;
        int value = sum / reset;
        Node right = new Node(value);
        trav = right;
        sum -= value*reset;
        reset /= 10;
        while (sum >= 1) {
            value = sum / reset;
            Node new_node = new Node(value);
            trav.next = new_node;
            trav = trav.next;
            sum -= value*reset;
            reset /= 10;
        }
        return right;
    }
}
