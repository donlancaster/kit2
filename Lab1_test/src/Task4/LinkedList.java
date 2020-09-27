package Task4;

import Task4.Node;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {// true, если список пуст
        return first == null;
    }

    public int size() {
        return size;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }


    public Node<E> get(int pos) {
        Node<E> current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current;
    }


    public void addLast(E item, PhoneType type) {
        Node<E> newLink = new Node<E>(item, type);
        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.prev = last;
        }
        last = newLink;
        size++;
    }

    public Node<E> deleteIndex(int pos) {
        Node<E> current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return null;
            else current = current.next;
        }
        if (current == first) first = current.next;
        else current.prev.next = current.next;
        if (current == last) last = current.prev;
        else current.next.prev = current.prev;
        size--;
        return current;
    }
}