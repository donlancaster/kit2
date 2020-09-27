package Task3;

import com.sun.org.apache.bcel.internal.generic.FSUB;

public class LinkedList {
    public static class Node {
        Sub sub;
        Node next;

        Node(String number, String name) {
            this.sub = new Sub(number, name);
        }
    }

    private int size;
    public Node first;
    public Node last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(String number, String name) {
        Node node = new Node(number, name);
        if (isEmpty()) first = node;
        else last.next = node;
        last = node;
        size++;
    }

    public void insertFirst(String number, String name) {
        Node node = new Node(number, name);
        if (isEmpty()) last = node;
        node.next = first;
        first = node;
        size++;
    }

    public void insertLast(String number, String name) {
        Node node = new Node(number, name);
        if (isEmpty())
            first = node;
        else
            last.next = node;
        last = node;
        size++;
    }

    public void delete(int index) {
        Node current = first;
        if (index == 0) {
            first = first.next;
        }
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void increment() {
        size++;
    }
}
