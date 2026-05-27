package BookManager;
import  java.io.Serializable;




public class Book implements Serializable  {

    private static final long serialVersionUID = 1L;
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
    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setWritername(String writername) {
        this.writername = writername;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
   
   
    
}
