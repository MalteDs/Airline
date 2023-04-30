package structures;
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Stack<T> {

    private Node<T> top;

    private int size;

    public Stack() {
        top = null;
        size = 0;
    }
    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.setNext(top);
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        T data = top.getValue();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = top;
        while (node != null) {
            sb.append(node.getValue());
            node = node.getNext();
            if (node != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
