// Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list. Each node represents a state of the text content (e.g., after typing a word or performing a command). Implement the following:
// Add a new text state at the end of the list every time the user types or performs an action.
// Implement the undo functionality (revert to the previous state).
// Implement the redo functionality (revert back to the next state after undo).
// Display the current state of the text.
// Limit the undo/redo history to a fixed size (e.g., last 10 states).

class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

class TextEditor {
    private Node head;
    private Node current;
    private int size;
    private final int HISTORY_LIMIT = 10;

    TextEditor() {
        head = new Node("");
        current = head;
        size = 1;
    }

    public void addState(String text) {
        Node newnode = new Node(text);

        if (size == HISTORY_LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }

        if (head == null) {
            head = newnode;
            current = head;
        } else {
            newnode.prev = current;
            current.next = newnode;
            current = newnode;
        }

        size++;

    }

    public void undo() {
        if (current.prev != null) {
            System.out.println("Undo: " + current.data);
            current = current.prev;
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.data);
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void display() {
        System.out.println("current state: " + current.data);
    }

}

public class RedoUnod {
    public static void main(String[] args) {
        TextEditor myTextEditor = new TextEditor();
        myTextEditor.addState("hello");
        myTextEditor.addState("bro");
        myTextEditor.addState("This is text");

        // undo
        myTextEditor.undo();
        myTextEditor.undo();

        // redo
        myTextEditor.redo();
        myTextEditor.redo();
        myTextEditor.redo(); // nothing to redo

        myTextEditor.display();

    }
}
