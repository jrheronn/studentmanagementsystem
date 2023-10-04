package assignment02;

import java.util.LinkedList;

// Header class for Course doubly linked list
public class Header {
    private int courseCount;
    private int totalStudentCount;
    private Courses head;
    private Courses tail;

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

    public int getTotalStudentCount() {
        return totalStudentCount;
    }

    public Courses getHead() {
        return head;
    }

    public Courses getTail() {
        return tail;
    }

    public Courses getCourse(String courseNumber) {
        Courses currentCourse = head;
        while (currentCourse != null) {
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                return currentCourse; // Course exist
            }
            currentCourse = currentCourse.getNext();
        }
        return null; // course does not exist
    }

    public void incrementTotalStudentCount() {
        totalStudentCount++;
    }

    public void incrementCourseCount(String courseNumber) {
        Courses currentCourse = head;

        while (currentCourse != null) {
            if (currentCourse.getCourseNumber().equals(courseNumber)) {
                currentCourse.incrementStudentCount();
                return;
            }
            currentCourse = currentCourse.getNext();
        }
    }

    public void addCourse(Courses course) {
        if(course == null) {
            return;
        }
        if (head == null) {
            head = course;
            tail = course;
        } else {
            tail.setNext(course);
            course.setPrevious(tail);
            tail = course;
        }
        courseCount++;
    }
}
