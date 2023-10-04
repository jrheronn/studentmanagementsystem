package assignment02;

// Class for course
public class Courses {
    private String courseName;
    private String courseNumber;
    private int studentCount;
    private Courses previous;
    private Courses next;
    private Students studentList;

    public Courses(String courseName, String courseNumber, int studentCount) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.studentCount = studentCount;
        this.previous = null;
        this.next = null;
        this.studentList = null;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = getCourseNumber();
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Courses getPrevious() {
        return previous;
    }

    public void setPrevious(Courses previous) {
        this.previous = previous;
    }

    public Courses getNext() {
        return next;
    }

    public void setNext(Courses next) {
        this.next = next;
    }

    public Students getStudentList() {
        return studentList;
    }

    public void setStudentList(Students studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Students student) {
        if (student == null) {
            return;
        }
        if (studentList == null) {
            // Create list if list is empty
            studentList = student;
        } else {
            // Add student to existing list
            Students currentStudent = studentList;
            while(currentStudent.getNext() != null) {
                currentStudent = currentStudent.getNext();
            }
            currentStudent.setNext(student);
        }
        // Increment student count for course
        studentCount++;
    }

    public void incrementStudentCount() {
        studentCount++;
    }
}
