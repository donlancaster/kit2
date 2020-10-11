package Task4;

public class Iterator<E> {
    private Node<E> current;
    private Node<E> previous;
    private final LinkedList<E> ourList;

    public Iterator(LinkedList<E> list)
    {
        ourList = list;
        reset();
    }

    public void reset()
    {
        current = ourList.getFirst();
        previous = null;
    }


    public void nextNode() {
        previous = current;
        current = current.next;
    }

    public Node<E> getCurrent()
    {
        return current;
    }


}
