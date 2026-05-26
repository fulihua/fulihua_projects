package BookManager;


public class Book {
    
    private String id,title,writername;                                                                                
    private double price;
    private int stock;

    public Book(String id,String i,String t,double p,int s){
        this.id = id;
        title = i;
        writername = t;
        price = p;
        stock = s;
    
    }
    public String getId(){return id;}
     public String getWritename(){return writername;}
    public String getTitle(){return title;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
   
    
}
