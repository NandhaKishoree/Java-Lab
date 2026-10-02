// Question 6: Constructor Overloading
class Rectangle {

    int length, breadth;

    public Rectangle() {
        length = 3;
        breadth = 3;
    }

    public Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    public Rectangle(int a) {
        length = a;
        breadth = a;
    }

    void Display() {
        System.out.println("Length : " + length);
        System.out.println("Breadth : " + breadth);
        System.out.println("Area : " + length * breadth);
        System.out.println("-----------------");
    }
}

class ConstructOverload{

    public static void main(String args[]) {
        Rectangle obj1 = new Rectangle();
        Rectangle obj2 = new Rectangle(5, 6);
        Rectangle obj3 = new Rectangle(8);
        obj1.Display();
        obj2.Display();
        obj3.Display();

    }
}
