package Task1;

public class LinkedList {
    private class Node {
        Coefficients item;
        Node next;

        public Node(int a, int n) {
            this.item = new Coefficients(a, n);
        }
    }


    private int size;
    public int highestDegree;
    public Node first;
    public Node last;

    public LinkedList() {
        size = 0;
        highestDegree = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(int a, int n) {
        if (a == 0) return;
        Node node = new Node(a, n);
        if (isEmpty()) first = node;
        else last.next = node;
        last = node;
        size++;
        if (n > highestDegree) highestDegree = n;
    }


    public void add(int a, int n, int pos) {
        Node node = new Node(a, n);
        if (isEmpty()) {
            first = node;
            return;
        }
        Node current = first;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
            if (current.next == null) return;
        }
        if (current == last) {
            node.next = null;
            last = node;
        } else node.next = current.next;
        node.next = current.next;
        size++;
        if (n > highestDegree) highestDegree = n;
    }


    public Coefficients get(int pos) {
        Node current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current.item;
    }


    public Node getLast() {
        return last;
    }

    public void delete(int pos) {
        Node current = first;
        for (int i = 0; i < pos - 1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        if (current.next.next != null)
            current.next = current.next.next;
        else current.next = null;
        size--;
    }


    public int getA(int degree) {
        Node current = first;
        while (current.item.n != degree) {
            if (current.next == null) return 0;
            else current = current.next;
        }
        return current.item.a;
    }
}