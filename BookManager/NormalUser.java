package BookManager;

public class NormalUser extends User{
    public NormalUser(String username,String password){
        super(username, password, "NormalUser");}
    public  void showMenu(){
        System.out.println("2.查看所有图书");
        System.out.println("5.查询图书");
        System.out.println("6.借书");
        System.out.println("7.还书");
        System.out.println("8.查看图书排行榜（按借阅次数排序");
        System.out.println("0.退出");
    }
    }
    

