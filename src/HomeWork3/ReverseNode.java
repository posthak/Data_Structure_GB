package HomeWork3;

public class ReverseNode {

    static Node head;

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printNode(Node node) {

        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ReverseNode list = new ReverseNode();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        System.out.println("Односвязный список");
        list.printNode(head);
        list.reverse();
        System.out.println("");
        System.out.println("Перевернутый односвязный список");
        list.printNode(head);
        System.out.println();
    }
}
