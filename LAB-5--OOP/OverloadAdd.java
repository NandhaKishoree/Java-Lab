// Question 3: Method Overloading – Addition
class Addition{
    public int add(int n1,int n2){
        return n1 + n2;
    }
    public int add(int n1,int n2,int n3){
        return n1 + n2 + n3;
    }
    public double add(double n1,double n2){
        return n1 + n2;
    }
}
class OverloadAdd{
    public static void main(String args[]){
        Addition obj = new Addition();
        int two = obj.add(3,2);
        int three = obj.add(3,2,5);
        double point = obj.add(3.5,5.3);
        System.out.println("Two int addition : "+two);
        System.out.println("Three int addition : "+three);
        System.out.println("Two decimals num addition : "+point);
    }
}