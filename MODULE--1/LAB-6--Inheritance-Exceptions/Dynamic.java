// 2. Write a Java program to demonstrate dynamic method dispatch using a superclass Shape and subclasses Circle and Rectangle. Override the draw() method in each subclass and invoke it using a superclass objerence.
class Shape {
    void draw() {
        System.out.println("Random shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Circle");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Rectangle");
    }
}

public class Dynamic {
    public static void main(String[] args) {
        Shape obj;         

        obj = new Circle();
        obj.draw();        
        obj.draw();      
    }
}