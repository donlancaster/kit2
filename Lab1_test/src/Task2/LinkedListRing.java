package Task2;

public class LinkedListRing {

    private int size;

    public Node2 first;
    public Node2 last;

    public LinkedListRing() {
        first = null;
        last = null;
    }

    public void add(int num) {
        Node2 node = new Node2(num);
        if (isEmpty())
            first = node;
        else {
            last.next = node;
        }
        last = node;
        node.next = first;
        size++;
    }

    public Node2 getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
