// Question 7: Constructor and Method Overloading
class Sides {

    private int length, breadth, height;

    public Sides() {

    }

    public Sides(int a) {
        length = a;
        breadth = a;
        height = a;
    }

    public Sides(int l, int b, int h) {
        length = l;
        breadth = b;
        height = h;
    }

    void Calculate() {
        System.out.println("Length : " + length);
        System.out.println("Breadth : " + breadth);
        System.out.println("Height : " + height);
        System.out.println("Volume : " + length * breadth * height);
        System.out.println("----------------------");
    }
}

class Dimension {

    public static void main(String args[]) {
        Sides obj1 = new Sides();
        Sides obj2 = new Sides(3);
        Sides obj3 = new Sides(3, 4, 5);
        obj1.Calculate();
        obj2.Calculate();
        obj3.Calculate();

    }
}
