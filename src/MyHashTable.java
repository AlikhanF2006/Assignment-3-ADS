public class MyHashTable<K, V> {

    // Inner class for a node in the hash chain
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int M = 11; // default number of buckets
    private HashNode<K, V>[] chainArray;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    // Hash function to compute index for a key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Insert key-value pair into the hashtable
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        // Check if key already exists and update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at the beginning of the chain
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    // Get value for a given key
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Get the number of key-value pairs in the hashtable
    public int size() {
        return size;
    }
}
