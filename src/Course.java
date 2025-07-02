public class Course {
    private String courseName;
    int courseId;
    private static int nextCourseId = 101;

    public Course(String courseName){
        this.setCourseName(courseName);
        this.courseId = nextCourseId++;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course: "  + courseName + '\'' +
                " Course ID=" + courseId;
    }
}
