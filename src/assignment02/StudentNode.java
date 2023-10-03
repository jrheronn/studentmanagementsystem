package assignment02;

// Class for a student node of the singly-linked list
public class StudentNode {
    private Student student;
    private StudentNode next;

    // Construtor to access class StudentNode
    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }

    public Student getStudent() {
        return student;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}
