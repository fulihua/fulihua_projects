package BookManager;
import  java.io.Serializable;
import java.util.Objects;




public class Book implements Serializable  {

    private static final long serialVersionUID = 1L;
    private String id,title,writername;                                                                                
    private double price;
    private int stock;
    private int borrowcount;

    public Book(String id,String i,String t,double p,int s){
        this.id = id;
        title = i;
        writername = t;
        price = p;
        stock = s;
        this.borrowcount = 0;
    
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
   
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Book))
            return false;
           Book other = (Book)obj;
            return id.equals(other.id);
           }
    
    public int hashCode(){
        return id.hashCode();
    }

    public String toString (){
        return "Book{id = "+id+",title = "+title+",author = "+writername+",price = "+price+",stock = "+stock+"}"; 
    }

    public int getborrowCount(){
        return borrowcount;
    }

    public void setborrowCount(int borrowcount){
        this.borrowcount = borrowcount;
    }
}
    
   

