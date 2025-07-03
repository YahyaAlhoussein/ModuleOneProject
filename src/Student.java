import java.util.ArrayList;

public class Student extends Person{

    private int studentId;
    private int grade;
    private ArrayList<Course> courses;
    private final int MAX_COURSES = 5;
    private static int nextStudentId = 1001;

    public Student(String name, int age, String email, int grade) {
        super(name, age, email);
        this.studentId = nextStudentId++;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 0){
            throw new IllegalArgumentException("Student's grade can not be negative");
        }
        this.grade = grade;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course course) {
        if (courses.size() < MAX_COURSES) {
            courses.add(course);
            return true;
        } else {
            System.out.println("Student cannot take more than " + MAX_COURSES + " courses.");
            return false;
        }
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", studentId=" + studentId +
                ", grade=" + grade +
                ", MAX_COURSES=" + MAX_COURSES;
    }
}
