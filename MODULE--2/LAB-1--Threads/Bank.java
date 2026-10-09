// Q4: Write a Java program where multiple threads update a shared bank account balance, show the problem, then fix it using the synchronized keyword.
//Synchronization
class Account {

    int balance = 1000;

    synchronized void withdraw(int amount) {
        if (amount < balance) {
            System.out.println(Thread.currentThread().getName() + " Is withdrawing amount " + amount);
            balance = balance - amount;
        } else {
            System.out.println("Insufficent Balance");
        }

    }

    void getbalance() {
        System.out.println("Current Balance : " + balance);
    }
}

class Bank {

    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account();
        Thread t1 = new Thread(() -> acc.withdraw(800), "Thread 1");
        Thread t2 = new Thread(() -> acc.withdraw(800), "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        acc.getbalance();
    }
}
