
// 2. Doubly Linked List: Movie Management System
// Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a movie and contain Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
// Add a movie record at the beginning, end, or at a specific position.
// Remove a movie record by Movie Title.
// Search for a movie record by Director or Rating.
// Display all movie records in both forward and reverse order.
// Update a movie's Rating based on the Movie Title.

import java.util.ArrayList;
import java.util.List;

class Node {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    Node next;
    Node prev;

    Node(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieMangemnet {

    Node head;

    public void addMovie(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void addMovieAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addItemAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newnode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    public void displayMovie() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Movie Title: " + temp.movieTitle + " Director: " + temp.director + " Year of Release: "
                    + temp.yearOfRelease + " Rating: " + temp.rating);
            temp = temp.next;
        }
        System.out.println();
    }

    public void addMovieAtPosition(String movieTitle, String director, int yearOfRelease, double rating, int position) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void displayReverse() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.println("Movie Title: " + temp.movieTitle + " Director: " + temp.director + " Year of Release: "
                    + temp.yearOfRelease + " Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void SearchbyDierctorOrRating(String directorName, double rating) {
        List<Node> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            if (temp.director.equals(directorName) || temp.rating == rating) {
                list.add(temp);

            }
            temp = temp.next;
        }

        for (Node x : list) {
            System.out.println("Movie Title: " + x.movieTitle + " Director: " + x.director + " Year of Release: "+ x.yearOfRelease + " Rating: " + x.rating);

        }

        if (list.isEmpty()) {
            System.out.println("Movie not found");
        }
    }

    public void removeMovieByTitle(String movieTitle) {
        Node temp = head;
        while (temp != null) {
            if (temp.movieTitle.equals(movieTitle)) {
                System.out.println(temp.movieTitle);
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void updateRating(String movieTitle, double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.movieTitle.equals(movieTitle)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

}

public class MovieManagemane {
    public static void main(String[] args) {
        MovieMangemnet m1 = new MovieMangemnet();
        m1.addItemAtEnd("pk", "rajkumar", 2016, 8.9);
        m1.addItemAtEnd("black", "rajkumar", 2025, 6);
        m1.addMovieAtPosition("Dark", "unknown", 2019, 8, 1);
        m1.displayMovie();

        m1.SearchbyDierctorOrRating("unknown", 0);
        m1.removeMovieByTitle("pk");
        m1.displayMovie();
       

    }
}
