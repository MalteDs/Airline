package structures;

public class PQNode<T> {
    private T value;
    private int priority;
    private PQNode<T> next;

    public PQNode(T value, int priority) {
        this.value = value;
        this.priority = priority;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PQNode<T> getNext() {
        return next;
    }

    public void setNext(PQNode<T> next) {
        this.next = next;
    }
}
