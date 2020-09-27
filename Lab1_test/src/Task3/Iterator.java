package Task3;

public class Iterator {
    private LinkedList.Node current;
    private LinkedList.Node previous;
    private LinkedList linkedList;

    public Iterator(LinkedList list) {
        linkedList = list;
    }

    public void reset() {
        current = linkedList.getFirst();
        previous = null;
    }

    public void nextNode() {
        previous = current;
        current = current.next;
    }

    public LinkedList.Node getCurrent() {
        return current;
    }

    public void insertBefore(String number, String name) {
        LinkedList.Node node = new LinkedList.Node(number, name);
        if (previous == null) {
            node.next = linkedList.getFirst();
            linkedList.first = node;
            reset();
        } else {
            node.next = previous.next;
            previous.next = node;
            current = node;
            linkedList.increment();
        }
    }
}

