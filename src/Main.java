public class Main {
    public static void main(String[] args) {
        // Create BST with Integer keys and String values
        BST<Integer, String> bst = new BST<>();

        // Insert some key-value pairs
        bst.put(50, "Apple");
        bst.put(30, "Banana");
        bst.put(70, "Cherry");
        bst.put(20, "Date");
        bst.put(40, "Elderberry");
        bst.put(60, "Fig");
        bst.put(80, "Grapes");

        System.out.println("Initial in-order traversal:");
        for (var entry : bst.iterator()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Test get
        System.out.println("\nGet key 40: " + bst.get(40)); // Elderberry

        // Test delete
        bst.delete(30); // delete node with two children

        System.out.println("\nIn-order after deleting key 30:");
        for (var entry : bst.iterator()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Test size
        System.out.println("\nBST size: " + bst.size());
    }
}
