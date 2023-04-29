package structures;

import java.util.NoSuchElementException;

public class PriorityQueue<T> {
    private PQNode<T> head;
    private int size;

    public PriorityQueue() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value, int priority) {
        PQNode<T> newNode = new PQNode<>(value, priority);
        if (isEmpty() || priority < head.getPriority()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            PQNode<T> current = head;
            while (current.getNext() != null && priority >= current.getNext().getPriority()) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.getValue();
    }


    @Override
    public String toString() {
        String result = "[";
        PQNode<T> pointer = head;
        while (pointer != null) {
            result += pointer.getValue() + ":" + pointer.getPriority();
            if (pointer.getNext() != null) {
                result += "\n";
            }
            pointer = pointer.getNext();
        }
        result += "]";
        return result;
    }
}
