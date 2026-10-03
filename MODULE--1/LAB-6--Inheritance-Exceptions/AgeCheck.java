// 9. Write a Java program to create a method checkAge(int age) that throws an exception using the throw keyword when the age is less than 18. Declare the exception using throws and handle it in the calling method.
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeCheck{
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18. Not eligible!");
        }
        System.out.println("Age " + age + " is eligible");
    }

    public static void main(String[] args) {
        try {
            checkAge(20);
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}