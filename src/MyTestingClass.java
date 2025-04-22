/**
 * This class is used for testing the custom MyHashTable implementation.
 * It includes a name and an ID, and overrides equals() and hashCode()
 * to serve as a proper key type in the hashtable.
 */
public class MyTestingClass {
    private String name;
    private int id;

    /**
     * Constructs a MyTestingClass object with a given name and ID.
     *
     * @param name the name of the object
     * @param id   the ID of the object
     */
    public MyTestingClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Checks equality between this object and another object.
     * Two objects are considered equal if they have the same name and ID.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTestingClass that = (MyTestingClass) o;
        return this.id == that.id && this.name.equals(that.name);
    }

    /**
     * Generates a custom hash code using the length of the name and the ID.
     *
     * @return an integer hash code
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.length();
        result = 31 * result + id;
        return result;
    }

    /**
     * Returns a string representation of this object for debugging purposes.
     *
     * @return a string in the format "name (id)"
     */
    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
