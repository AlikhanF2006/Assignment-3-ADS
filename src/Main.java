import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Part 1: BST test
        BST<Integer, String> bst = new BST<>();
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

        System.out.println("\nGet key 40: " + bst.get(40));
        bst.delete(30); // delete node with two children

        System.out.println("\nIn-order after deleting key 30:");
        for (var entry : bst.iterator()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\nBST size: " + bst.size());

        // Part 2: MyHashTable test with 10,000 elements
        System.out.println("\n=== HashTable Test ===");

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);
        Random random = new Random();

        // Insert 10,000 random key-value pairs
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + (i % 100); // repeated names to create collisions
            int id = random.nextInt(10000);   // random ID for variety
            MyTestingClass key = new MyTestingClass(name, id);
            Student value = new Student("Student" + i, 18 + (i % 5));
            table.put(key, value);
        }

        // Display distribution of entries per chain
        System.out.println("Hash table chain distribution:");
        for (int i = 0; i < 100; i++) {
            System.out.printf("Chain %02d: %d entries%n", i, table.getChainSize(i));
        }
    }
}
