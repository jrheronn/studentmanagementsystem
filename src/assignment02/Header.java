package assignment02;

// Header class for Course doubly linked list
public class Header {
    private int courseCount;
    private int totalStudentCount;
    private Course head;
    private Course tail;

    public Header() {
        this.courseCount = 0;
        this.totalStudentCount = 0;
        this.head = null;
        this.tail = null;
    }

    // Getters and setters
    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getTotalStudentCount() {
        return totalStudentCount;
    }

    public void setTotalStudentCount(int totalStudentCount) {
        this.totalStudentCount = totalStudentCount;
    }

    public Course getHead() {
        return head;
    }

    public void setHead(Course head) {
        this.head = head;
    }

    public Course getTail() {
        return tail;
    }

    public void setTail(Course tail) {
        this.tail = tail;
    }
}
