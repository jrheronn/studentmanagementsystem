package assignment02;

public class CourseDoublyLinkedList {
    private CourseNode head;
    private CourseNode tail;
    // Add insert
    public void insert(Course course) {

    }

    public void displayCourseList() {
        CourseNode current = head;

        if (current == null) {
            System.out.println("Course list is empty");
            return;
        }

        System.out.println("Course List:");
        while (current != null) {
            Course course = current.getCourse();
            System.out.println(course.getCourseNumber() + course.getCourseName());
            current = current.getNext();
        }
    }

    public void addCourse(Course course) {
        CourseNode newNode = new CourseNode(course);

        // If list is empty
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }
}
