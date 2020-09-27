package Task2;

public class Iterator {
    private Node2 current;
    private final LinkedListRing listRing;

    public Iterator(LinkedListRing list) {
        listRing = list;
        reset();
    }

    public void reset() {
        current = listRing.getFirst();
    }

    public void next() {
        current = current.next;
    }

    public Node2 getCurrent() {
        return current;
    }

    public void remove() {
        Node2 preCurrent = listRing.first;
        while (!preCurrent.next.equals(current)) {
            preCurrent = preCurrent.next;
        }
        preCurrent.next = preCurrent.next.next;
    }
}
