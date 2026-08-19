package day24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java. util.Collections;
import java.util.Set;
import java.util.TreeSet;

import day23.FileOutPutStreamDemo;
import day24.Student;

public class Test4 {
    private static final String LINE_SEPARATOR  = System.getProperty(("line.separator"));
    public static void main(String[] args) throws IOException{
        //4.将学生对象（姓名，语文分数，数学分数，英语分数，总分）按照总分从高到低排序
        //并将姓名和从高到低总分写入到文件中。
        /*
        思路：
        1.描述学生。
        2.既然要按照总分从高到低排序，学生多要存储集合。TreeSet.
        3.将所有具体的信息保存到文件中。
            操作文件，持久化存储，涉及了IO技术，而且是将数据存储到文件中。所以写入，输出流。
        */
       Set<Student> set = new TreeSet<Student>(Collections.reverseOrder());
       set.add(new Student("李四",20,20,20));
       set.add(new Student("旺财",10,10,20));
       set.add(new Student("小明",60,30,70));
       set.add(new Student("小红",80,90,90));
       set.add(new Student("小强",20,70,20));
       File dir = new File("tempfile");
       if(!dir.exists()){
        dir.mkdir();
       }
       File desFile = new File(dir,"student_info.txt");
       write2File(set,desFile);


    }
    public static void write2File(Set<Student> set,File desFile) throws IOException{
        //1.创建输出流对象和目的文件关联。并创建目的文件。OutputStream操作文件 FileOutputStream.
        FileOutputStream fos = null;
       try{
        fos = new FileOutputStream(desFile);
        //2.遍历集合中的对象数据，将数据写入到指定文件中。
        
        for(Student stu:set){
            String info = stu.getName()+"\\t"+stu.getSum()+LINE_SEPARATOR;
            //3.将数据写入到文件中。
            fos.write(info.getBytes());
        }
       }finally{
            if(fos!=null){
                //关闭资源
                try{
                    fos.close();
                }catch(IOException e){
                    throw new RuntimeException("系统资源关闭失败");
                }
            }
       }

    }
}


/*
问：
这个代码中，set.add(new Student("李四",20,20,20));
		set.add(new Student("旺财",10,10,20));
		set.add(new Student("小明",60,30,70));
		set.add(new Student("小红",80,90,80));
		set.add(new Student("小强",20,70,20));这一段也没有说添加到哪里啊？


答：
在代码的开头部分，你已经创建了一个 `TreeSet` 对象，并赋值给了变量 `set`：

```java
Set<Student> set = new TreeSet<Student>(Collections.reverseOrder());
```

所以，`set.add(new Student(...))` 中的 `set` 就是指向这个 `TreeSet` 集合。这些 `add` 操作就是把学生对象添加到这个集合中。
因此，并不是“没有说添加到哪里”，而是添加到了之前创建的那个 `set` 对象中。你可能是漏看了那一行定义。

追问：
那这个TreeSet 对象，是啥类型啊？如果是文件的话，不应该先创建文件夹，然后再创建文件再往里面填充吗？为啥是先创建了文件之后，在创建文件夹啊？

答：
你混淆了两个完全不同的概念：

- **`TreeSet<Student> set`** 是一个**内存中的集合**（类似于一个容器），用于临时存储学生对象，并按照指定的比较器（`Collections.reverseOrder()`）对元素进行排序。它**不是文件**，也不会在磁盘上创建任何东西。

- **文件操作**（如 `File dir = new File("tempfile")`、`destFile`、`FileOutputStream` 等）是用来**将内存中的数据持久化到磁盘**上的。

所以代码的执行顺序是：
1. 先在内存中创建 `TreeSet` 集合，并添加学生对象（这些学生暂时只存在于内存中，按总分降序排序）。
2. 然后创建文件夹（`tempfile`）和文件（`student_info.txt`）。
3. 最后调用 `write2File` 方法，将内存中排好序的学生信息写入到磁盘文件中。

**先创建文件对象（`File`）并不代表文件立即被创建**，`new File(...)` 只是在内存中创建一个代表路径的 `File` 对象，实际的文件是在 `new FileOutputStream(destFile)` 时才在磁盘上创建的。所以不存在“先创建文件再创建文件夹”的问题，因为文件夹是在写入之前就已经 `mkdir()` 创建好了。

希望这个解释能帮你理清顺序。
*/

/*
问：
这个代码中，为啥if(fos!=null){
				
				//关闭资源。文件不等于空，就要关闭资源呢？

答：
`fos` 是 `FileOutputStream` 类型的一个引用变量。在 `try` 块中，`fos = new FileOutputStream(destFile)` 可能会因为磁盘满、权限不足等原因抛出异常，导致 `fos` 没有被成功赋值，保持为 `null`。在 `finally` 块中，如果 `fos` 不为 `null`，说明已经成功创建了输出流对象，占用了系统资源（如文件句柄），必须调用 `fos.close()` 来释放这些资源。
如果 `fos` 为 `null`，则说明从未成功创建流，自然不需要关闭，强行调用 `close()` 会引发 `NullPointerException`。因此，`if (fos != null)` 是一个安全判断，确保只在有资源需要关闭时才进行关闭操作。这是一种标准的资源释放写法。
*/

/*
问：
Set<Student> set这个是啥意思啊？创建 FileOutputStream 指向 destFile，如果文件不存在会自动创建。这个操作又是在干嘛？为啥要将字符串转为字节数组？为啥要用try，catch？为啥在write2File函数后面写了throws IOException，在代码中还要再写一个throw new RuntimeException("系统资源关闭失败")？

答：我们来逐一回答你的问题。

### 1. `Set<Student> set` 是什么意思？
- `Set` 是 Java 集合框架中的一个接口，表示一个不允许包含重复元素的集合。
- `<Student>` 是泛型，表示这个 `Set` 中只能存放 `Student` 类型的对象。
- `set` 是变量名。
- 这里具体创建的是 `TreeSet<Student>` 对象，它实现了 `Set` 接口，并且元素会按自然顺序或比较器排序。

---

### 2. 创建 `FileOutputStream` 指向 `destFile`，如果文件不存在会自动创建。这个操作在干嘛？
- `FileOutputStream` 是 Java 中用于向文件写入原始字节的输出流。
- 当 `new FileOutputStream(destFile)` 时，会在磁盘上**创建**（如果不存在）或**覆盖**（如果已存在）该文件，并建立程序到该文件的连接。
- 之后调用 `fos.write(byte[])` 就会把数据写入到这个文件中。

---

### 3. 为啥要将字符串转为字节数组？
- `FileOutputStream` 是字节流，只能写入字节（`byte` 类型数据）。
- 字符串是字符序列，不能直接写入，必须先通过 `getBytes()` 方法将字符串转换为字节数组（按照平台默认字符集编码），然后写入。

---

### 4. 为啥要用 `try-catch`？
- `FileOutputStream` 构造器、`write` 方法、`close` 方法都声明抛出 `IOException`（检查型异常）。
- `try-catch` 用于捕获并处理这些异常，避免程序崩溃。
- 这里在 `finally` 块中关闭流，确保无论是否发生异常，都会尝试关闭资源。

---

### 5. 为啥在 `write2File` 函数后面写了 `throws IOException`，在代码中还要再写一个 `throw new RuntimeException("系统资源关闭失败")`？
- `throws IOException` 声明该函数可能抛出 `IOException`，调用者需要处理或继续抛出。
- 但在 `finally` 块中关闭流时，`fos.close()` 也可能抛出 `IOException`。如果此时捕获到 `close` 的异常，原方法的主要业务异常可能被掩盖，或者我们不想让调用者处理这个关闭时的异常（因为文件已经写入完成，关闭失败通常不是致命问题），所以这里捕获后包装成 `RuntimeException` 抛出，表示系统资源关闭失败，让程序终止或上层统一处理。
- 这是一种常见的处理方式：不把 `close` 的异常向上抛出，而是转换成非检查型异常，因为关闭失败通常不影响业务数据。

希望这些解释能帮你理解代码。如果还有疑问，请继续问。

追问：
1. Set<Student> set 是什么意思？这个问题中，明明在函数上已经标注了set了，为啥在调用函数时的括号里面还要再写一个set？write2File(set,destFile)?
2.FileOutputStream 是 Java 中用于向文件写入原始字节的输出流。
在这个问题的解答中，既然是写入输出流的，那和代码中的set.add(new Student("李四",20,20,20));又有啥区别？为啥不继续用set.add了？
3.还有4. 为啥要用 try-catch？和5. 为啥在 write2File 函数后面写了 throws IOException，在代码中还要再写一个 throw new RuntimeException("系统资源关闭失败")？问题我没太听懂，给我通俗易懂的讲一下

答：
我们来用一个**非常通俗的比喻**重新解释你的问题。

---

## 1. `Set<Student> set` 是什么意思？为什么调用时括号里还要再写一个 `set`？

**比喻：**  
你有一个**篮子**（集合），名字叫 `set`，里面可以放学生（`Student`）。  
你还有一个**打印机**（`write2File` 函数），它能把东西打印到纸上。  
打印机需要一个篮子作为原料。  

- 你在 `main` 里声明：`Set<Student> set = ...` → 这就是你拿了一个篮子，并给它贴上名字“set”。
- 然后你喊：`write2File(set, destFile);` → 这是说：“打印机，请把我手里这个名叫‘set’的篮子里的东西打出来。”

所以括号里的 `set` 就是告诉打印机“用这个篮子”。如果篮子名字叫 `mySet`，就写 `write2File(mySet, ...)`。**形参是占位符，实参是具体的篮子**。

---

## 2. `FileOutputStream` 和 `set.add` 有什么区别？为什么不继续用 `set.add`？

- `set.add(...)`：往篮子里**放**学生。
- `FileOutputStream`：把篮子里的学生**写到纸上**（保存到文件）。

**它们不是一回事**。你不能用 `set.add` 来写文件，就像你不能用“把苹果放进篮子”这个动作来“把苹果画到纸上”。所以必须先放好学生，再另起炉灶用文件流写出。

---

## 3. 为什么用 `try-catch`？为什么函数已有 `throws IOException` 还要在 `finally` 里 `throw new RuntimeException`？

**比喻：**  
你要把一箱贵重的玻璃杯运到仓库。  
- `throws IOException` 就像你在出发前告诉别人：“路上可能会路滑摔碎杯子，出了事别怪我。”  
- `try` 块就是你小心翼翼搬杯子。
- `catch` 块是：如果中途滑了一下（出现异常），你赶紧扶住杯子，然后找个地方先放稳（做清理工作）。
- `finally` 块是：不管搬没搬成，你最后都要关上仓库门（关闭文件流）。

**关仓库门也可能出问题**，比如门锁坏了。这时如果也抛出异常，会把你之前“杯子摔了”的信息覆盖掉。所以你专门处理关门异常：如果门锁坏了，你就大喊一声“门坏了！”（抛出一个 `RuntimeException`），但先确保杯子的事已经记录好了。

**简单说**：  
- `throws` 是告诉别人“可能会失败”。  
- `try-catch` 是让你有机会做善后（比如关文件）。  
- `finally` 里再抛异常是因为关文件失败往往不是主要业务错误，但也要通知程序员，所以转成一个不需要强制处理的 `RuntimeException`。

---

希望这个比喻能让你完全明白。如果还有哪句不通，请指出，我再换种说法。

追问：
write2File(set, destFile); → 这是说：“打印机，请把我手里这个名叫‘set’的篮子里的东西打出来。”你的意思是让打印机将set的篮子打印到destFile上吗？
set.add(...)：往篮子里放学生。

FileOutputStream：把篮子里的学生写到纸上（保存到文件）。
他们俩的区别在于一个是将数据写入到了数据流中（飘着悬浮），而另一个是将数据踏踏实实的写在了文件当中吗？
为什么用 try-catch？为什么函数已有 throws IOException 还要在 finally 里 throw new RuntimeException？
这个问题中，你的解释是如果我没抛RuntimeException，那么当仓库门坏了时，也会抛出hrows IOException 这个异常，导致我不知道这个异常代表的到底是玻璃杯摔坏了，还是仓库门坏了。所以我再另外抛出一个异常，以此来表示仓库门坏了，对吗？

答：
正确

 */

