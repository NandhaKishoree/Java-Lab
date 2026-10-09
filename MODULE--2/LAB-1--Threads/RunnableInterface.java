// Q3: Write a Java program to create two or more threads by implementing the Runnable interface, each performing a separate task.
//Creating Threads using Runnable Interface
class PrintingNum implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class PrintingLine implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi guys");
        }
    }
}

class RunnableInterface {

    public static void main(String[] args) {
        Runnable obj1 = new PrintingNum();
        Runnable obj2 = new PrintingLine();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}
