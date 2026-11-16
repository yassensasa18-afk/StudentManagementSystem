/** A course may have one assigned lecturer. */
public class Course {
    private String code;
    private String title;
    private Lecturer lecturer; // association: a course may have one lecturer (or none)
    public Course(String code, String title) { setCode(code); setTitle(title); }
    public String getCode() { return code; }
    // Setter rejects an empty course code
    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) throw new IllegalArgumentException("Code cannot be empty.");
        this.code = code.trim();
    }
    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title.trim();
    }
    public Lecturer getLecturer() { return lecturer; }
    public void setLecturer(Lecturer lecturer) { this.lecturer = lecturer; }
    // Returns one formatted line describing the course
    public String getDetails() {
        return code + " | " + title + " | Lecturer: " + (lecturer == null ? "Not assigned" : lecturer.getName());
    }
}
