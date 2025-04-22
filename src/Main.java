public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        MyTestingClass key1 = new MyTestingClass("Alice", 101);
        MyTestingClass key2 = new MyTestingClass("Bob", 102);

        Student student1 = new Student("Alice A.", 19);
        Student student2 = new Student("Bob B.", 20);

        table.put(key1, student1);
        table.put(key2, student2);

        System.out.println("Key1 => " + table.get(key1));
        System.out.println("Key2 => " + table.get(key2));
    }
}
