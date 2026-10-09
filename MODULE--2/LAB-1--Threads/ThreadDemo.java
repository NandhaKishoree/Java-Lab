// Q2: Write a Java program to create three threads by extending the Thread class (print numbers, display characters, display a message) and run them concurrently.
//Creating Threads using Thread Class
class Numbers extends Thread{
      public  void run(){
                for(int i=0;i<5;i++){
                    System.out.println(i);
                  }
}
}
class Char extends Thread{
    public void run(){
        for(char ch = 'A';ch<='E';ch++){
            System.out.println(ch);
        }
    }
}
class Message extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hi Guys");
        }
    }
}
class ThreadDemo{
    public static void main(String[] args) {
        Numbers obj1 = new Numbers();
        Char obj2 = new Char();
        Message obj3 = new Message();
        obj1.start();
        obj2.start();
        obj3.start(); 
    }
}