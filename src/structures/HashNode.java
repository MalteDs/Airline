package structures;

public class HashNode<K, V> {
    private final K key;
    private V value;
    private HashNode next;
    private HashNode previous;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    public HashNode getPrevious() {
        return previous;
    }

    public void setPrevious(HashNode previous) {
        this.previous = previous;
    }
}
