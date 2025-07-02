import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the School Management System!");
        boolean exit = false;

        while (!exit) {
            printMenu();
            try {
                int choice;
                String choiceCheker = scanner.next();
                if (choiceCheker == null || choiceCheker.trim().isEmpty() || !isNumeric(choiceCheker)) {
                    choice = -1;
                } else {
                    choice = Integer.parseInt(choiceCheker);
                }
                scanner.nextLine();

                switch (choice) {
                    case 1: addStudent();
                            break;
                    case 2: addTeacher();
                            break;
                    case 3: addCourse();
                            break;
                    case 4: assignCourseToStudent();
                            break;
                    case 5: assignCourseToTeacher();
                            break;
                    case 6: viewStudentById();
                            break;
                    case 7: viewAllStudentsAndTeachers();
                            break;
                    case 8: viewAllCourses();
                            break;
                    case 9: updateStudent();
                            break;
                    case 10: deleteStudent();
                            break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 11.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
    private static void printMenu() {
        System.out.println("\nMain Menu: ");
        System.out.println("1. Add a Student");
        System.out.println("2. Add a Teacher");
        System.out.println("3. Add a Course");
        System.out.println("4. Assign Course to Student");
        System.out.println("5. Assign Course to Teacher");
        System.out.println("6. View Student by ID");
        System.out.println("7. View All Students and Teachers");
        System.out.println("8. View All Courses");
        System.out.println("9. Update Student");
        System.out.println("10. Delete Student");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (isEmpty(name)){
            System.out.println("Name can not be empty.");
            return;
        }
        System.out.print("Enter student age: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Age must be a number.");
            return;
        }
        int age = Integer.parseInt(inputCheck);
        scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        if (isEmpty(email)){
            System.out.println("Email can not be empty.");
            return;
        }
        System.out.print("Enter student grade: ");
        inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Grade must be a number.");
            return;
        }
        int grade = Integer.parseInt(inputCheck);
        scanner.nextLine();

        Student newStudent = new Student(name, age, email, grade);
        students.add(newStudent);
        System.out.println("Student added successfully! New Student ID: " + newStudent.getStudentId());
    }

    private static void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        if (isEmpty(name)) {
            System.out.println("Name can not be empty.");
            return;
        }
        System.out.print("Enter teacher age: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Age must be a number.");
            return;
        }
        int age = Integer.parseInt(inputCheck);
        scanner.nextLine();
        System.out.print("Enter teacher email: ");
        String email = scanner.nextLine();
        if (isEmpty(email)){
            System.out.println("Email can not be empty.");
            return;
        }
        System.out.print("Enter teacher subject: ");
        String subject = scanner.nextLine();
        if (isEmpty(subject)){
            System.out.println("Subject can not be empty.");
            return;
        }

        Teacher newTeacher = new Teacher(name, age, email, subject);
        teachers.add(newTeacher);
        System.out.println("Teacher added successfully! New Teacher ID: " + newTeacher.getTeacherId());
    }

    private static void addCourse() {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        if (isEmpty(name)){
            System.out.println("Course name can not be empty.");
            return;
        }
        Course newCourse = new Course(name);
        courses.add(newCourse);
        System.out.println("Course added successfully! New Course ID: " + newCourse.getCourseId());
    }

    private static void assignCourseToStudent() {
        System.out.print("Enter Student ID to assign course: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Student ID must be a number.");
            return;
        }
        int studentId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course ID to assign: ");
        inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Course ID must be a number.");
            return;
        }
        int courseId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.addCourse(course)) {
            System.out.println("Course '" + course.getCourseName() + "' assigned to " + student.getName() + ".");
        }
    }

    private static void assignCourseToTeacher() {
        System.out.print("Enter Teacher ID to assign course: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Student ID must be a number.");
            return;
        }
        int teacherId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Teacher teacher = findTeacherById(teacherId);

        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.print("Enter Course ID to assign: ");
        inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Course ID must be a number.");
            return;
        }
        int courseId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (teacher.addCourse(course)) {
            System.out.println("Course '" + course.getCourseName() + "' assigned to " + teacher.getName() + ".");
        }
    }

    private static void viewStudentById() {
        System.out.print("Enter Student ID to view: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Student ID must be a number.");
            return;
        }
        int studentId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("\nStudent Found: ");
            System.out.println(student);
            System.out.println("Courses Enrolled:");
            if (student.getCourses().isEmpty()) {
                System.out.println("  None");
            } else {
                for (Course c : student.getCourses()) {
                    System.out.println("  - " + c);
                }
            }
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private static void viewAllStudentsAndTeachers() {
        System.out.println("\nAll Students:" );
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }

        System.out.println("\nAll Teachers: ");
        if (teachers.isEmpty()) {
            System.out.println("No teachers in the system.");
        } else {
            for (Teacher t : teachers) {
                System.out.println(t);
            }
        }
    }

    private static void viewAllCourses() {
        System.out.println("\nAll Courses: ");
        if (courses.isEmpty()) {
            System.out.println("No courses in the system.");
        } else {
            for (Course c : courses) {
                System.out.println(c);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Student ID must be a number.");
            return;
        }
        int studentId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("What do you want to update?");
        System.out.println("1. Name\n2. Age\n3. Email\n4. Grade");
        System.out.print("Choice: ");
        inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Enter a valid number.");
            return;
        }
        int choice = Integer.parseInt(inputCheck);
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                inputCheck = scanner.nextLine();
                if (isEmpty(inputCheck)){
                    System.out.println("Name can not be empty.");
                    return;
                }
                student.setName(inputCheck);
                break;
            case 2:
                System.out.print("Enter new age: ");
                inputCheck = scanner.nextLine();
                if (isNumeric(inputCheck)){
                    System.out.println("Age must be a number.");
                    return;
                }
                student.setAge(Integer.parseInt(inputCheck));
                scanner.nextLine();
                break;
            case 3:
                System.out.print("Enter new email: ");
                inputCheck = scanner.nextLine();
                if (isEmpty(inputCheck)){
                    System.out.println("Email can not be empty.");
                    return;
                }
                student.setEmail(inputCheck);
                break;
            case 4:
                System.out.print("Enter new grade: ");
                inputCheck = scanner.nextLine();
                if (isNumeric(inputCheck)){
                    System.out.println("Grade must be a number.");
                    return;
                }
                student.setGrade(Integer.parseInt(inputCheck));
                scanner.nextLine();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Student details updated successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String inputCheck = scanner.next();
        if (!isNumeric(inputCheck)) {
            System.out.println("Student ID must be a number.");
            return;
        }
        int studentId = Integer.parseInt(inputCheck);
        scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student != null) {
            students.remove(student);
            System.out.println("Student " + student.getName() + " has been deleted.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    private static Teacher findTeacherById(int id) {
        for (Teacher t : teachers) {
            if (t.getTeacherId() == id) {
                return t;
            }
        }
        return null;
    }

    private static Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty())
            return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isEmpty(String str) {
        if (str == null || str.isEmpty())
            return true;
        return false;
    }
}