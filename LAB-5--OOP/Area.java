// Question 4: Method Overloading – Area Calculation
class Calculate{
    int get(int n){
        return n*n;
    }
    int get(int n1 ,int n2){
        return n1*n2;
    }
    double get(double n){
        return Math.PI*n*n;
    }
}
class Area{
    public static void main(String args[]){
        Calculate area = new Calculate();
        int square = area.get(5);
        int rectangle = area.get(3,4);
        double circle = area.get(4);
        System.out.println("Square area : "+square+"m^2");
        System.out.println("Rectangle area : "+rectangle+"m^2");
        System.out.println("Circle area : "+circle+"m^2");
    }
}