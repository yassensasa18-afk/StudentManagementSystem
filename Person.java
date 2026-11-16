/** Common identity and abstract behaviour for every person. */
/**
 * Abstract superclass for every person in the system (abstraction).
 * Holds the shared identity data used by Student and Lecturer.
 */
public abstract class Person {
    // Private fields: only accessible through getters and setters (encapsulation)
    private String id;
    private String name;
    // Constructor validates values through the setters
    public Person(String id, String name) { setId(id); setName(name); }
    public String getId() { return id; }
    // Setter rejects empty IDs to keep records valid
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID cannot be empty.");
        this.id = id.trim();
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name.trim();
    }
    // Abstract method: every subclass must provide its own version (polymorphism)
    public abstract String getDetails();
}
