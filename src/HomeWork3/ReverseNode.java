package HomeWork3;

public class ReverseNode {

    static Node head;
    static Node tail;

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
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

    // Добавление многосвязанного списка
    public void addFirstMul(int value) {
        Node node = new Node(value);
        // node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Добавление односвязанного списка
    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeLast() {
        if (tail != null && tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ReverseNode list = new ReverseNode();
        list.addFirstMul(1);
        list.addFirstMul(9);
        list.addFirstMul(11);

        System.out.println("Односвязный список");
        list.printNode(head);
        list.reverse();
        System.out.println("");
        System.out.println("Перевернутый односвязный список");
        list.printNode(head);
        System.out.println();
    }
}
