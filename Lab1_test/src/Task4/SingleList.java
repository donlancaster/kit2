package Task4;

public class SingleList {

    private int size;

    public Node first;
    public Node last;

    public SingleList() {
        size = 0;
        first = null;
        last = null;
    }

    public void add(int number, PhoneType type) {
        Node newNode = new Node(number, type);
        if (isEmpty())
            first = newNode;
        else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(int number, PhoneType type, int pos) {
        Node current = first;

        pos--;
        for (int i = 0; i < pos; i++) {
            current = current.next;
            if (current.next == null) return;
        }
        Node newNode = new Node(number, type);
        if (current == last)
        {
            newNode.next = null;
            last = newNode;
        } else
        {
            newNode.next = current.next;
        }
        current.next = newNode;
        size++;
    }

    public int get(int pos) {
        Node current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return 0;
            else current = current.next;
        }
        return current.number;
    }

    public Node getLast() {
        return last;
    }

    public void deleteIndex(int pos) {
        Node current = first;
        for (int i = 0; i < pos-1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class Node {
        int number;
        PhoneType type;
        Node next;

        Node(int number, PhoneType type) {
            this.number = number;
            this.type = type;
        }
    }
}
