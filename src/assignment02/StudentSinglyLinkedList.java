package assignment02;

// Class for student singly linked list
public class StudentSinglyLinkedList {
    private StudentNode head;

    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);

        // If list is empty
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

    }
}
