# Assignment 3 – HashTable and BST (Algorithms and Data Structures)
---

## Contents

- [`MyHashTable.java`](./MyHashTable.java)
- [`MyTestingClass.java`](./MyTestingClass.java)
- [`BST.java`](./BST.java)
- [`Student.java`](./Student.java)
- [`Main.java`](./Main.java)

---

## Part 1: HashTable Implementation (50%)

### Implemented in `MyHashTable.java`

- `put(K key, V value)` – insert or update key-value pairs
- `get(K key)` – retrieve value by key
- `remove(K key)` – delete key-value pair
- `contains(V value)` – check if a value exists
- `getKey(V value)` – get the key for a specific value
- `hash(K key)` – custom hash function

### Testing with `MyTestingClass` and `Student`

- `MyTestingClass` is used as a custom key class with:
  - Overridden `equals()`
  - Custom `hashCode()` (no `Objects.hash()` used)
- Inserted **10,000** random entries
- Printed number of entries in each hash bucket

---

## Part 2: Binary Search Tree Implementation (50%)

### Implemented in `BST.java`

- `put(K key, V value)` – non-recursive insertion
- `get(K key)` – non-recursive search
- `delete(K key)` – deletion of nodes (0, 1, or 2 children)
- `size()` – number of elements in the tree
- `iterator()` – in-order traversal using a custom stack-based iterator

### Iteration Output

The `iterator()` method allows:
```java
for (var elem : bst.iterator()) {
    System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
}
