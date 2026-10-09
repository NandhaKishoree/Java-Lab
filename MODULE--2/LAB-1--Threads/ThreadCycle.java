// Q1: Write a Java program to show a thread's life cycle (New, Runnable, Timed Waiting, Terminated) by creating a thread, starting it, making it sleep, and letting it complete.
//Thread Life Cycle
class Life extends Thread{
   public void run(){
        System.out.println("Thread is Running!");
        try {
            System.out.println("Thread is sleeping");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class ThreadCycle{
    public static void main(String[] args) {
        Life obj = new Life();
        System.out.println(obj.getState());
        obj.start();
        System.out.println(obj.getState());
        try {
            obj.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread Terminated!");
    }
}