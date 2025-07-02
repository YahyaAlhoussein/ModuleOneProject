import java.util.ArrayList;

public class Teacher extends Person{
    private int teacherId;
    private String subject;
    private ArrayList<Course> courses;
    private final int MAX_COURSES_TAUGHT = 3;

    private static int nextTeacherId = 501;

    public Teacher(String name, int age, String email, String subject) {
        super(name, age, email);
        this.teacherId = nextTeacherId++;
        this.setSubject(subject);
        this.courses = new ArrayList<>();
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        this.subject = subject;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course course) {
        if (courses.size() < MAX_COURSES_TAUGHT) {
            courses.add(course);
            return true;
        } else {
            System.out.println("Teacher cannot teach more than " + MAX_COURSES_TAUGHT + " courses.");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                ", courses=" + courses +
                ", MAX_COURSES_TAUGHT=" + MAX_COURSES_TAUGHT;
    }
}
