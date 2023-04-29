package structures;

public class HashTable<K, V> {
    private int size;
    private HashNode<K, V>[] table;

    public HashTable(int capacity) {
        this.table = new HashNode[capacity];
        this.size = 0;
    }


    public void put(K key, V value) {
        int i = hash(key);
        HashNode<K, V> pointer = table[i];

        while (pointer != null) {
            if (pointer.getKey().equals(key)) {
                pointer.setValue(value);
                return;
            }
            pointer = pointer.getNext();
        }

        HashNode<K, V> newHashNode = new HashNode<>(key, value);
        newHashNode.setNext(table[i]);
        table[i] = newHashNode;
        size++;

        if (size >= table.length * 0.75) {
            addSize(table.length * 2);
        }
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> pointer = table[index];

        while (pointer != null) {
            if (pointer.getKey().equals(key)) {
                return pointer.getValue();
            }
            pointer = pointer.getNext();
        }

        return null;
    }

    public V remove(K key) {
        int i = hash(key);
        HashNode<K, V> pointer = table[i];
        HashNode<K, V> previous = null;

        while (pointer != null) {
            if (pointer.getKey().equals(key)) {
                if (previous == null) {
                    table[i] = pointer.getNext();
                } else {
                    previous.setNext(pointer.getNext());
                }
                size--;
                return pointer.getValue();
            }
            previous = pointer;
            pointer = pointer.getNext();
        }

        return null;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }


    public int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }


    private void addSize(int newCapacity) {
        HashNode<K, V>[] newTable = new HashNode[newCapacity];

        for (HashNode<K, V> hashNode : table) {
            while (hashNode != null) {
                int i = hash(hashNode.getKey());
                HashNode<K, V> newHashNode = new HashNode<>(hashNode.getKey(), hashNode.getValue());
                newHashNode.setNext(newTable[i]);
                newTable[i] = newHashNode;
                hashNode = hashNode.getNext();
            }
        }

        table = newTable;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        String  message = "[";
        for (int i = 0; i < table.length; i++) {
            HashNode<K, V> pointer = table[i];
            if (pointer != null) {
                message += pointer.getValue() + "\n";
                while (pointer.getNext() != null) {
                    pointer = pointer.getNext();
                    message += pointer.getKey() + ": " + pointer.getValue() + ", ";
                }
            }
        }
        return message + "]";
    }
}