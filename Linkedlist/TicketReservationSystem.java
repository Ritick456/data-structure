
class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    private Ticket head = null;
    private Ticket tail = null;
    private int totalTickets = 0;

    // Add a new ticket reservation at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        // Traverse the circular linked list
        do {
            if (current.ticketID == ticketID) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (found) {
            if (current == head && current == tail) {
                head = null;
                tail = null;
            } else if (current == head) {
                head = head.next;
                tail.next = head;
            } else if (current == tail) {
                tail = prev;
                tail.next = head;
            } else {
                prev.next = current.next;
            }
            totalTickets--;
            System.out.println("Ticket " + ticketID + " removed successfully.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println(
                    "Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName +
                            ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchQuery) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchQuery) || temp.movieName.equalsIgnoreCase(searchQuery)) {
                System.out.println("Ticket Found -> Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + searchQuery);
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();

        // Adding ticket reservations
        system.addTicket(101, "John", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "Raj", "Batman", "B2", "1:00 PM");
        system.addTicket(103, "Deepak", "Superman", "C3", "3:00 PM");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Batman");

        // Remove a ticket
        system.removeTicket(102);
        system.displayTickets();

        // Get total tickets booked
        System.out.println("Total Tickets Booked: " + system.getTotalTickets());
    }
}
