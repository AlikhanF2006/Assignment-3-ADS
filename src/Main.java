public class Main {
    public static void main(String[] args) {
        MyHashTable<String, String> table = new MyHashTable<>();

        table.put("apple", "fruit");
        table.put("carrot", "vegetable");
        table.put("banana", "fruit");

        System.out.println("carrot -> " + table.get("carrot"));

        table.remove("carrot");
        System.out.println("carrot -> " + table.get("carrot"));

        System.out.println("Contains 'fruit': " + table.contains("fruit"));
        System.out.println("Contains 'vegetable': " + table.contains("vegetable"));

        System.out.println("Key for 'fruit': " + table.getKey("fruit"));
    }
}
