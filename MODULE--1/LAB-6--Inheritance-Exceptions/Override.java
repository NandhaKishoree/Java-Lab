// 1. Write a Java program to create a superclass Animal with a method sound(). Create subclasses Dog and Cat that override the sound() method. Display the appropriate sound for each animal.
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow Meow");
    }
}

public class Override {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
    }
}