package Task4;

public class Node<E> {
    public PhoneType type;
    public E item;
    public Node<E> next;
    public Node<E> prev;
    public Node(E item, PhoneType type) {
        this.item = item;
        this.type = type;
    }
}
