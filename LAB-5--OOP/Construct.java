// Question 5: Default and Parameterized Constructors
class Book{
    private String title,author;
    private int price;

    //Default Constructor
    public Book(){
      title = "killadi";
        author = "akshay kumar";
        price = 30;
    }
    
    //parameterized Constructor
    public Book(String a,String b,int n){
        title = a;
        author = b;
        price = n;
    }
    public void show(){
        System.out.println("-------Book Details------");
        System.out.println("Title : "+title);
        System.out.println("Author : "+author);
        System.out.println("Price : "+price);
    }
}
class Construct{
    public static void main(String args[]){
        Book obj1 = new Book();
        Book obj2 = new Book("Baaghi 3","Tiger shroff",20);
        obj1.show();
        obj2.show();
    }
}