import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random random = new Random();

        // Insert 10,000 entries
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + random.nextInt(10000);
            int id = random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(name, id);

            String studentName = "Student" + i;
            int studentAge = 18 + random.nextInt(5);
            Student student = new Student(studentName, studentAge);

            table.put(key, student);
        }

        // Print number of entries in each bucket (distribution)
        System.out.println("Hash table distribution across buckets:");
        for (int i = 0; i < 11; i++) {
            int count = countBucket(table, i);
            System.out.println("Bucket " + i + ": " + count + " entries");
        }

        System.out.println("Total entries: " + table.size());
    }

    // Access internal chainArray using reflection
    private static <K, V> int countBucket(MyHashTable<K, V> table, int index) {
        try {
            var field = MyHashTable.class.getDeclaredField("chainArray");
            field.setAccessible(true);
            Object[] array = (Object[]) field.get(table);

            int count = 0;
            Object node = array[index];
            var nodeClass = node != null ? node.getClass() : null;

            while (node != null) {
                var nextField = nodeClass.getDeclaredField("next");
                nextField.setAccessible(true);
                node = nextField.get(node);
                count++;
            }

            return count;
        } catch (Exception e) {
            return 0;
        }
    }
}
