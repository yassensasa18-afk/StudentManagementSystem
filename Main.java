import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/** Console entry point. All records remain in memory until exit. */
public class Main {
    // Scanner for keyboard input and in-memory lists for all records
    private static final Scanner input = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
    private static final List<Lecturer> lecturers = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();
    // Prints a prompt and returns the trimmed line the user typed
    private static String read(String prompt) {
        System.out.print(prompt);
        if (!input.hasNextLine()) return "";
        return input.nextLine().trim();
    }
    // Search helpers: return the matching record, or null if not found
    private static Student student(String id) {
        for (Student s : students) if (s.getId().equalsIgnoreCase(id)) return s;
        return null;
    }
    private static Lecturer lecturer(String id) {
        for (Lecturer l : lecturers) if (l.getId().equalsIgnoreCase(id)) return l;
        return null;
    }
    private static Course course(String code) {
        for (Course c : courses) if (c.getCode().equalsIgnoreCase(code)) return c;
        return null;
    }
    // Main menu loop: repeats until the user chooses 0
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add student\n2. Add lecturer\n3. Add course\n4. Display all people\n5. Display courses\n6. Register student in course\n7. Display student registrations\n0. Exit");
            System.out.print("Choose: ");
            if (!input.hasNextLine()) break; // stop cleanly at end of input
            String choice = input.nextLine().trim();
            try {
                switch (choice) {
                    case "1": { // Add a new student (ID must be unique)
                        String id = read("Student ID: ");
                        if (student(id) != null || lecturer(id) != null) { System.out.println("ID already exists."); break; }
                        students.add(new Student(id, read("Name: "), read("Programme: ")));
                        System.out.println("Student added successfully."); break;
                    }
                    case "2": { // Add a new lecturer (ID must be unique)
                        String id = read("Lecturer ID: ");
                        if (student(id) != null || lecturer(id) != null) { System.out.println("ID already exists."); break; }
                        lecturers.add(new Lecturer(id, read("Name: "), read("Department: ")));
                        System.out.println("Lecturer added successfully."); break;
                    }
                    case "3": { // Add a course, optionally linked to a lecturer
                        String code = read("Course code: ");
                        if (course(code) != null) { System.out.println("Course already exists."); break; }
                        Course c = new Course(code, read("Course title: "));
                        String id = read("Lecturer ID (blank for none): ");
                        if (!id.isEmpty()) {
                            Lecturer l = lecturer(id);
                            if (l == null) { System.out.println("Lecturer not found. Course not added."); break; }
                            c.setLecturer(l);
                        }
                        courses.add(c); System.out.println("Course added successfully."); break;
                    }
                    case "4": {
                        List<Person> people = new ArrayList<>();
                        people.addAll(students); people.addAll(lecturers);
                        if (people.isEmpty()) System.out.println("No people found.");
                        // Superclass references select subclass implementations at runtime.
                        for (Person person : people) System.out.println(person.getDetails());
                        break;
                    }
                    case "5": // Display all courses
                        if (courses.isEmpty()) System.out.println("No courses found.");
                        for (Course c : courses) System.out.println(c.getDetails());
                        break;
                    case "6": { // Register a student in a course (no duplicates)
                        Student s = student(read("Student ID: "));
                        Course c = course(read("Course code: "));
                        if (s == null || c == null) System.out.println("Student or course not found.");
                        else System.out.println(s.registerCourse(c) ? "Registration successful." : "Student already registered.");
                        break;
                    }
                    case "7": { // Show a student and the courses they registered
                        Student s = student(read("Student ID: "));
                        if (s == null) { System.out.println("Student not found."); break; }
                        System.out.println(s.getDetails());
                        if (s.getCourses().isEmpty()) System.out.println("No registrations found.");
                        for (Course c : s.getCourses()) System.out.println(c.getDetails());
                        break;
                    }
                    case "0": running = false; System.out.println("Goodbye."); break;
                    default: System.out.println("Invalid option. Choose 0 to 7.");
                }
            } catch (IllegalArgumentException e) { // invalid input rejected by a setter
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }
}
