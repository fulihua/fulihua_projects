package BookManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ConsoleUI {
    private BookService bookService;
    private Scanner sc;
    private User currentUser;
    HashMap<String,User> hsmap = new HashMap<String,User>();
    HashMap<Integer,MenuCommand> commands = new HashMap<Integer,MenuCommand>();
    public interface MenuCommand {
        void execute();
    }

    public ConsoleUI(BookService bookService){
        this.bookService = bookService;
        this.sc = new Scanner(System.in);
        hsmap.put("admin",new Admin("admin", "123"));
        hsmap.put("normaluser",new NormalUser("normaluser", "123"));

    }
    public void start(){
        commands.put(1,new MenuCommand(){
               public void execute(){
                if(!(currentUser instanceof Admin)){
                System.out.println("无权限，只有管理员可执行此操作！");
               return;
            }
            System.out.println("请输入按顺序输入：书名，作者，价格，库存。");
            String bookname,writername;
            double price;
            int stock;
            bookname = sc.nextLine();
            writername = sc.nextLine();
            price = sc.nextDouble();
            stock = sc.nextInt();
            Result<String> result = bookService.addBook(bookname, writername, price, stock);
           if(result.isSuccess()){
            System.out.println("添加成功！ID为"+result.getData());
           }
        }
            });
        
       commands.put(2,new MenuCommand() {
            public void execute(){

            if(bookService.getAllBooks().isEmpty()==true){
                System.out.println("暂无图书");}
            else{
                        printBooks(bookService.getAllBooks());
                    }
                }
       });
            
       commands.put(3,new MenuCommand() {
            public void execute(){

             if(!(currentUser instanceof Admin)){
                System.out.println("无权限，只有管理员可执行此操作！");
                return;
            }
            System.out.println("请输入要输出图书的ID:");
            String id3 = sc.nextLine().trim();
            Result<Book> result = bookService.findBookById(id3);
            if(!result.isSuccess()){
                    System.out.println(result.getMessage());
                    return;
            }
            else{
                        Book tempbook = result.getData();
                        showBookInfo(tempbook);
                        System.out.println("确定要将此图书删除吗？(Yes/NO)");
                        String choice3 = sc.nextLine();
                       if(choice3.equals("Yes")){
                        Result<Void> delresult = bookService.deleteBook(id3);
                        if(delresult.isSuccess()){
                            System.out.println("删除成功！");
                        }
                        else {
                            System.out.println("删除失败：" + delresult.getMessage());
                        }
                    }
                        else{System.out.println("操作取消");}
                       
                }           
            }
        });

         commands.put(4,new MenuCommand() {
            public void execute(){

             if(!(currentUser instanceof Admin)){
                System.out.println("无权限，只有管理员可执行此操作！");
                return;
            }
            System.out.println("请输入要修改图书的ID");
            String id4 = sc.nextLine().trim();
            Result<Book> result = bookService.findBookById(id4);
            if(!result.isSuccess()){
                 System.out.println("没有找到对应ID的图书"+result.getMessage());}
            else{
                Book book = result.getData();
                showBookInfo(book);
                System.out.println("请选择要修改的字段：");
                System.out.println("1. 书名"); 
                System.out.println("2. 作者");
                System.out.println("3. 价格");   
                System.out.println("4. 库存" );
                System.out.println("5. 全部修改");  
                System.out.println("0. 取消");   
                int choice4 = sc.nextInt();
                sc.nextLine();
                switch (choice4) {
                    case 1:
                        System.out.println("请输入新书名:");
                        String newbookname = sc.nextLine();
                        book.setTitle(newbookname);
                         System.out.println("修改成功！");
                        break;
                    case 2:
                        System.out.println("请输入新作者:");
                        String newwritername = sc.nextLine();
                        book.setWritername(newwritername);
                         System.out.println("修改成功！");
                        break;
                     case 3:
                        System.out.println("请输入新价格:");
                        double newprice = sc.nextDouble();
                        book.setPrice(newprice);
                         System.out.println("修改成功！");
                        break;
                     case 4:
                        System.out.println("请输入新库存:");
                        int newstock = sc.nextInt();
                        book.setStock(newstock);
                         System.out.println("修改成功！");
                        break;
                     case 5:
                        System.out.println("请依次输入新书名、新作者、新价格、新库存:");
                        String newbookname4 = sc.nextLine();
                         book.setTitle(newbookname4);
                        String newwritername4 = sc.nextLine();
                        book.setWritername(newwritername4);
                        double newprice4 = sc.nextDouble();
                         book.setPrice(newprice4);
                        int newstock4 = sc.nextInt();
                        book.setStock(newstock4);
                        System.out.println("修改成功！");
                        break;
                    default:
                        break;}                                         
                }
            }
        });

         commands.put(5,new MenuCommand() {
            public void execute(){

                System.out.println("请输入关键字:");
                String keywords = sc.nextLine();
                ArrayList<Book> temporary=bookService.searchBooks(keywords);
                if(temporary.isEmpty() == true){
                    System.out.println("未找到对应的图书");
                }
                else{
                    printBooks(temporary);  
                    }
                }
        });

        commands.put(6,new MenuCommand() {
            public void execute(){

            System.out.println("请输入将借图书的ID");
            String id6 = sc.nextLine().trim();
            Result<Void> borrowResult = bookService.borrowBook(id6);
            if(borrowResult.isSuccess()){
            Result<Book> result = bookService.findBookById(id6);
            if(result.isSuccess()){
                Book book = result.getData();
                System.out.println("借书成功！"+"当前库存为"+book.getStock());}
            }
            else{
                System.out.println("借书失败：" + borrowResult.getMessage());
            }
             }
            });
             
        
         commands.put(7,new MenuCommand() {
            public void execute(){

            System.out.println("请输入将归还图书的ID");
            String id7 = sc.nextLine().trim();
            Result<Void> retunResult = bookService.returnBook(id7);
            if(retunResult.isSuccess()){
                 Result<Book> result = bookService.findBookById(id7);
            if(result.isSuccess()){
                Book book = result.getData();
                System.out.println("还书成功！"+"当前库存为"+book.getStock());
                }
            }
            else{
                System.out.println("还书失败！"+retunResult.getMessage());
            }
             
        }
        });

         commands.put(8,new MenuCommand() {
            public void execute(){

            System.out.println("想要查询排行榜前多少名？");
            int count = sc.nextInt();
            ArrayList<Book>  temp = bookService.getTopBooksByBorrowCount(count);
            if(temp.isEmpty()){System.out.println("暂无排行榜");}
            else{printBooksAppand(temp);}}
        });

          login();
        while(true){
        currentUser.showMenu();
        int choice = sc.nextInt();
        sc.nextLine();
        MenuCommand cmd = commands.get(choice);
        if(choice == 0){
            FileHelper.getInstance().saveBooks(bookService.getAllBooks(),"bookmanager.dat");
            break;}
        if(cmd != null){cmd.execute();  
        }
        else{
                System.out.println("无效选项"); 
            }
        }
    }
    
        
        
         public  void showBookInfo(Book b){
         System.out.println(b.getId()+"      "+b.getTitle()+"      "+b.getWritename()+"      "+b.getPrice()+"      "+b.getStock());
    }

        public void printBooks(ArrayList<Book> printbook){
            StringBuilder sb = new StringBuilder();
            sb.append("ID\t\t\t\t\t|\t书名\t|\t作者\t|\t价格\t|\t库存\n");
            for(Book b:printbook){
                sb.append(b.getId()).append("\t|\t").append(b.getTitle()).append("\t|\t").append(b.getWritename()).append("\t|\t").append(b.getPrice()).append("\t|\t").append(b.getStock()).append("\n");
            }
            System.out.print(sb.toString());
        }

         public void printBooksAppand(ArrayList<Book> printbook){
            StringBuilder sb = new StringBuilder();
            sb.append("ID\t\t\t\t\t|\t书名\t|\t作者\t|\t价格\t|\t库存\t|\t借阅次数\n");
            for(Book b:printbook){
                sb.append(b.getId()).append("\t|\t").append(b.getTitle()).append("\t|\t").append(b.getWritename()).append("\t|\t").append(b.getPrice()).append("\t|\t").append(b.getStock()).append("\t|\t").append(b.getBorrowCount()).append("\n");
            }
            System.out.print(sb.toString());
        }

        public void login(){
            while(true){
                System.out.println("请输入用户名:");
                String temp = sc.nextLine().trim();
                  if(hsmap.get(temp)==null){
                    System.out.println("该用户名不存在！");
                    continue;
                }
                else{
                    User found = hsmap.get(temp);
                    System.out.println("请输入密码:");
                    String temppassword = sc.nextLine();
                    boolean choice = found.checkPassword(temppassword);
                    if(choice == true){System.out.println("欢迎回来！");
                    currentUser = found;
                    break;}
                    else{System.out.println("信息错误，请重试！");}
                }
               
            }
            
        }
    }

    


