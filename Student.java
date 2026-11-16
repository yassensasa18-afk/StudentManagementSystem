import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** Student inherits identity and maintains course registrations. */
/** Student inherits id and name from Person and adds a programme and course list. */
public class Student extends Person {
    private String programme;
    // Courses this student is registered in
    private final List<Course> courses = new ArrayList<>();
    public Student(String id, String name, String programme) {
        super(id, name); // reuse the Person constructor (inheritance)
        setProgramme(programme);
    }
    public String getProgramme() { return programme; }
    public void setProgramme(String programme) {
        if (programme == null || programme.trim().isEmpty()) throw new IllegalArgumentException("Programme cannot be empty.");
        this.programme = programme.trim();
    }
    // Returns a read-only view so the list can only change through registerCourse
    public List<Course> getCourses() { return Collections.unmodifiableList(courses); }
    // Registers a course; returns false if the student is already registered
    public boolean registerCourse(Course course) {
        if (course == null) throw new IllegalArgumentException("Course is required.");
        if (courses.contains(course)) return false;
        courses.add(course); return true;
    }
    // Overrides the abstract method from Person
    @Override public String getDetails() {
        return "Student | " + getId() + " | " + getName() + " | " + programme;
    }
}
