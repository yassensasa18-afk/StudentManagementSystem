/** Lecturer is another concrete type of Person. */
/** Lecturer inherits id and name from Person and adds a department. */
public class Lecturer extends Person {
    private String department;
    public Lecturer(String id, String name, String department) {
        super(id, name); // reuse the Person constructor (inheritance)
        setDepartment(department);
    }
    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) throw new IllegalArgumentException("Department cannot be empty.");
        this.department = department.trim();
    }
    // Overrides the abstract method from Person
    @Override public String getDetails() {
        return "Lecturer | " + getId() + " | " + getName() + " | " + department;
    }
}
