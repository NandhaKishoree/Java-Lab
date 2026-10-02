// Question 8: Garbage Collection – Objects Eligible for Collection
class Waste{
    void Display(){
        System.out.println("Hello!");
    }
}
class garbage{
    public static void main(String args[]){
        Waste obj1 = new Waste();
        Waste obj2 = new Waste();
        Waste obj3 = new Waste();
        obj2 = null;
        obj3 = null;
        obj1.Display();
        System.gc();
        obj2.Display();
       

    }
}