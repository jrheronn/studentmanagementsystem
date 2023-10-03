package assignment02;

public class CourseNode {
    private Course course;
    private CourseNode next;
    private CourseNode previous;

    public  CourseNode(Course course) {
        this.course = course;
        this.next = null;
        this.previous = null;
    }

    public Course getCourse() {
        return course;
    }

    public CourseNode getNext() {
        return next;
    }

    public void setNext(CourseNode next) {
        this.next = next;
    }

    public CourseNode getPrevious() {
        return previous;
    }

    public void setPrevious(CourseNode previous) {
        this.previous = previous;
    }
}
