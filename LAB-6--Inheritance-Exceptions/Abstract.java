// 3. Write a Java program to create an abstract class Vehicle containing an abstract method start() and a concrete method display(). Create subclasses Car and Bike and implement the start() method in each subclass.
abstract class Vehicle {
    abstract void start();

    void display() {
        System.out.println("This is a vehicle");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a key or button");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a kick or self-start");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Car car = new Car();
        car.display();
        car.start();

        Bike bike = new Bike();
        bike.display();
        bike.start();
    }
}