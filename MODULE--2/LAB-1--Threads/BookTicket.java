// Q5: Write a Java program for a ticket booking system where multiple customer threads book from a limited ticket pool using synchronization, and display booking details and remaining tickets.
//Multithreading with Synchronization
class Booking {

    int tickets = 10;

    synchronized void book(int booked) {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " booked " + booked + " Ticket(s)");
            tickets = tickets - booked;
            System.out.println("Tickets remaining : " + tickets);
        } else {
            System.out.println("Uh oh... The limited edition Tickets booking has ended");
        }
    }
}

class BookTicket {

    public static void main(String[] args) {
        Booking obj = new Booking();
        Thread t1 = new Thread(() -> obj.book(5), "Naveen");
        Thread t2 = new Thread(() -> obj.book(5), "Sagal");
        Thread t3 = new Thread(() -> obj.book(5), "abhishake");
        t1.start();
        t2.start();
        t3.start();
    }
}
