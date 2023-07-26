package Lesson4;

public class seminar4<K, V> {
    private final int SIZE = 10;
    private int length = 0;
    private double loadFactor = 0.75;

    List[] list;

    public seminar4(int size) {
        this.list = (List[]) new Object[size];
    }

    public seminar4() {
        this.list = (List[]) new Object[SIZE];
    }

    public int calculateBacketIndex(K key) {
        return key.hashCode() % list.length;
    }

    public V findValueInList(K key) {
        int index = calculateBacketIndex(key);
        if (list[index] != null) {
            return list[index].findValue(key);
        }
        return null;
    }

    public boolean addItem(K key, V value) {
        if (list.length > length * loadFactor) {
            reCalculate();
        }
        Entity ne = new Entity();
        ne.key = key;
        ne.value = value;
        int index = calculateBacketIndex(key);
        List itemList = list[index];
        if (itemList == null) {
            itemList = new List();
            list[index] = itemList;
        }
        boolean flag = list[index].add(ne);
        if (flag)
            length++;
        return flag;
    }

    public boolean revmoveItem(K key) {
        int index = calculateBacketIndex(key);
        boolean flag = list[index].remove(key);
        if (flag)
            length--;
        return flag;
    }

    public void reCalculate() {
        List[] old = list;
        list = (List[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            List itemList = old[i];
            List.Node node = itemList.head;
            while (node != null) {
                addItem(node.data.key, node.data.value);
                node = node.next;
            }
            old[i] = null;
        }

    }

    private class Entity {
        private K key;
        private V value;
    }

    private class List {
        private Node head;

        private class Node {
            private Node next;
            private Entity data;
        }

        public V findValue(K key) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(key)) {
                    return node.data.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean add(Entity item) {
            boolean flag = false;
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(item.key)) {
                    return false;
                }
                if (node.next == null)
                    break;
                node = node.next;
            }
            Node newNode = new Node();
            newNode.data = item;
            return true;
        }

        public boolean remove(K key) {
            Node node = head;
            Node previus = head;
            if (head != null) {
                if (head.data.key.equals(key)) {
                    head = head.next;
                    return true;
                }
            }
            while (node != null) {
                if (node.data.key.equals(key)) {
                    previus.next = node.next;
                    return true;
                }
                previus = node;
                node = node.next;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        // System.out.println("Односвязный список");
    }
}