package structures;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public Queue() {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T data = front.getValue();
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return front.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        Node<T> current = front;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> pointer = front;
        while (pointer != null) {
            sb.append(pointer.getValue().toString());
            if (pointer.getNext() != null) {
                sb.append(", ");
            }
            pointer = pointer.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}