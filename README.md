2026年6月1日

# 图书管理系统



## 项目简介

基于Java的控制台管理系统，支持图书的增删改查，借阅归还，排行榜，用户登录权限及数据持久化。



## 功能列表

--登录（管理员/普通用户）

--添加、删除、修改、查询图书

--查看所有图书

--借书/还书（自动更新库存与借阅次数）

--借阅次数排行榜

--数据自动保存

--操作日志记录（UTF-8编码）

--权限控制（管理员全功能，普通用户仅借阅查询）



## 技术栈

-Java 11

-集合（HashMap、ArrayList)

-泛型( Result<T> 统一返回值)

-I/O(序列化、字符流日志)

-内部类 + 命令模式

-单例模式（FileHelper）



## 运行方法

1. 克隆项目到本地

2. 切换到项目根目录（包含 BookManager 文件夹的目录）

3. 执行编译：javac BookManager/*.java

4. 执行运行：java BookManager.Main

5. 默认账号：'admin/123'（管理员），'normaluser/123'（普通用户）

   

## 项目结构

BookManager/
|── Book.java
|── BookService.java
|── ConsoleUI.java
|── FileHelper.java
|── Logger.java
|── Result.java
|── User.java
|── Admin.java
|── NormalUser.java
|── Main.java
└── （自定义异常类已删除）



## **开发步骤与知识点覆盖**

完整知识点覆盖改造计划（共11步，由易到难）

| 步骤      | 知识点覆盖                  | 具体改造内容                                                 | 涉及课程     |
| --------- | --------------------------- | ------------------------------------------------------------ | ------------ |
| 1         | 封装、单一职责              | 抽取 `BookService`（业务逻辑）和 `ConsoleUI`（界面交互），`Main` 仅负责启动。 | day06-07     |
| 2         | `Object` 类方法、`String`   | 重写 `Book` 类的 `equals()`、`hashCode()`、`toString()`；在模糊查询中使用 `StringBuilder` 高效拼接输出。 | day10, day17 |
| 3         | 泛型、`Map`、`Collections`  | 将存储从 `ArrayList<Book>` 改为 `HashMap<String, Book>`（key=id）；实现图书排行榜（按借阅次数排序，用 `Collections.sort()` 或 `TreeSet`）。 | day18-21     |
| 4         | 自定义异常、包              | 定义 `BookNotFoundException`、`StockNotEnoughException` 等业务异常，在 `BookService` 中抛出，在 `ConsoleUI` 中捕获处理。 | day12-13     |
| 5         | 继承、抽象类、接口、多态    | 定义 `User` 抽象父类，派生出 `Admin` 和 `NormalUser`；定义 `IBookManager` 接口，`BookService` 实现；登录后根据权限显示不同菜单。 | day08-10     |
| 6         | 单例模式、静态              | 将 `FileHelper` 改造为**单例模式**（私有构造+静态 `getInstance()`），保证全局唯一文件操作实例。 | day08        |
| 7         | 内部类、匿名内部类          | 在 `ConsoleUI` 中使用**内部类** `MenuCommand` 封装菜单选项对应的操作；或使用匿名内部类简化菜单事件处理。 | day11        |
| 8(未完成) | 多线程、锁                  | 增加**后台自动保存**线程（`ScheduledExecutorService` 每5分钟保存一次）；借书/还书方法使用 `synchronized` 或 `ReentrantLock` 保证线程安全。 | day14-16     |
| 9         | 日期时间、字符流、日志      | 记录操作日志：每次增删改查借还均追加到 `log.txt`，包含时间（`LocalDateTime`）和操作详情；使用 `FileWriter` 和 `BufferedWriter`。 | day22, day24 |
| 10        | `File` 类、字节流、编码解码 | 在启动时用 `File` 类检查 `books.dat` 是否存在、大小；将日志文件以 **UTF-8** 编码写入（指定 `Charset`）；理解字节流与字符流的转换。 | day23, day25 |
| 11        | 泛型类/方法                 | 定义泛型类 `Result<T>`（包含 `success`、`message`、`data`），让所有业务方法返回 `Result<T>`，统一操作结果。 | day20        |

---

## 



## 改进方向

1.多线程

2.添加图形界面

3.改用数据库存储

4.网络借阅功能



## 心得

这是我第一次完成一个小项目，也多亏了deepseek的提示，我才得以完成。此次练习的目的主要是：巩固我刚学完的Java基础知识，让这些知识能够融汇贯通，加深印象。此次练习还有许多不足，比如没有完成步骤八：多线程。以后有时间我一定会补上。还是在步骤11时的泛型操作让我感到困惑，我无法很好的理解这些操作。这些不足我会在以后一一完善！总之，这是我的第一个项目，我很高兴!



## 作者

fulihua



