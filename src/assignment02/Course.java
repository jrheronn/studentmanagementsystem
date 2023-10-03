package assignment02;

// Class for course
public class Course {
    private String courseName;
    private String courseNumber;
    private int studentCount;
    private Course previous;
    private Course next;
    private StudentSinglyLinkedList studentLinkedList;

    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.studentCount = 0;
        this.previous = null;
        this.next = null;
        this.studentLinkedList = new StudentSinglyLinkedList();
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = getCourseNumber();
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
