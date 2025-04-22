# Assignment 3 – HashTable and BST

This project is a Java implementation of a Hash Table and a Binary Search Tree (BST), developed as part of the course "Algorithms and Data Structures"

Recursion is not used in this assignment, as per the requirements.

---

## Contents

- MyHashTable.java
- MyTestingClass.java
- BST.java
- Student.java
- Main.java

---

## Part 1: HashTable Implementation

### Implemented in MyHashTable.java

- `put(K key, V value)` – inserts or updates a key-value pair
- `get(K key)` – retrieves the value by key
- `remove(K key)` – removes a key-value pair
- `contains(V value)` – checks if the value exists in the table
- `getKey(V value)` – returns the key associated with a value
- `hash(K key)` – custom hash function without using Objects.hash()

### Testing with MyTestingClass and Student

- `MyTestingClass` is used as a key class with custom `equals()` and `hashCode()`
- Inserted 10,000 randomly generated `MyTestingClass` objects as keys with corresponding `Student` values
- Printed the number of entries in each hash bucket to analyze distribution

---

## Part 2: Binary Search Tree (BST) Implementation

### Implemented in BST.java

- `put(K key, V value)` – inserts a key-value pair without recursion
- `get(K key)` – retrieves a value by key
- `delete(K key)` – removes a key-value pair
- `size()` – returns the number of nodes in the tree
- `iterator()` – returns an in-order traversal of key-value pairs using an explicit stack

### Iteration Format

During iteration, both key and value are accessible:
```java
for (var elem : bst.iterator()) {
    System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
}

