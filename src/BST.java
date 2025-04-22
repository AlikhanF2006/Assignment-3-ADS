/**
 * Custom Binary Search Tree (BST) implementation.
 * Supports insertion, search, and deletion of key-value pairs.
 */
public class BST<K extends Comparable<K>, V> {

    /**
     * Inner class representing a node in the BST.
     */
    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    /**
     * Inserts a key-value pair into the BST (non-recursive).
     */
    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node(key, value);
                    size++;
                    return;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.value = value; // update existing
                return;
            }
        }
    }

    /**
     * Retrieves the value associated with the given key.
     */
    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.value;
        }
        return null;
    }

    /**
     * Deletes a node with the specified key from the BST.
     */
    public void delete(K key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            // node with one or no children
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // node with two children: replace with min in right subtree
            Node minNode = findMin(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = deleteNode(node.right, minNode.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * Returns the number of elements in the BST.
     */
    public int size() {
        return size;
    }
}
