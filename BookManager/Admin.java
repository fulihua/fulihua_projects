package BookManager;

public class Admin extends User {
     public Admin(String username,String password){
        super(username,password,"admin");
    }
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        System.out.println("1.添加图书");
        System.out.println("2.查看所有图书");
        System.out.println("3.删除图书");
        System.out.println("4.修改图书信息");
        System.out.println("5.查询图书");
        System.out.println("6.借书");
        System.out.println("7.还书");
        System.out.println("8.查看图书排行榜（按借阅次数排序");
        System.out.println("0.退出");
    }
}

