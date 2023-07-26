package Lesson4;

public class Tree {
    private Node root;

    private enum Color {
        RED, BLACK
    }

    public void add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = balance(root);
            root.color = Color.BLACK;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
        }
    }

    public boolean addNode(Node node, int value) {
        if (node.value == value)
            return false;
        if (node.value > value) {
            if (node.left != null) {
                boolean result = addNode(node.left, value);
                node.left = balance(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.color = Color.RED;
                node.left.value = value;
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, value);
                node.right = balance(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.color = Color.BLACK;
                node.right.value = value;
                return true;
            }
        }
    }

    private Node balance(Node node) {
        Node result = node;
        boolean isBalance;
        do {
            isBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                isBalance = true;
                result = rightRotate(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.left.left != null
                    && result.left.left.color == Color.RED) {
                isBalance = true;
                result = leftRotate(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                isBalance = true;
                colorSwap(result);
            }
        } while (isBalance);
        return result;
    }

    private Node rightRotate(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftRotate(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private class Node {
        private int value;
        private Color color;
        private Node left;
        private Node right;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.value + " " + node.color + "  ");
            print(node.right);
        }
    }

    public static void main(String[] args) {
        Tree node = new Tree();
        node.add(0);
        System.out.println("\n");
        node.add(12);
        node.print();
        System.out.println("\n");
        node.add(33);
        node.print();
        System.out.println("\n");
        node.add(14);
        node.print();
        System.out.println("\n");
        node.add(63);
        node.print();
        System.out.println("\n");
        node.add(-2);
        node.print();
        System.out.println("\n");

    }
}