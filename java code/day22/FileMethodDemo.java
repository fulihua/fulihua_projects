package day22;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {
    public static void main(String[] args){
        /*
        File类的方法演示
        获取文件的信息。名称，大小，时间
        */
       File file = new File("Test22.java");

       String absPath = file.getAbsolutePath();
       String path = file.getPath();//File中封装的路径是什么获取到的就是什么。
       String filename = file.getName();
       long size = file.length();
       long time = file.lastModified();

       System.out.println("absPath="+absPath);
       System.out.println("path="+path);
       System.out.print("filename="+filename);
       System.out.println("size+"+size);
       System.out.println("time="+time);

       //毫秒值--Date--格式化--字符串文本
       String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(time));
       System.out.println(str_date);
    }
}


//4月26日  复习

public class FileMethodDemo{
    public static void main(String[] args){
        /*
        File 类的方法演示
        获取文件的信息。名称，大小，时间
        */
       File file = new File("Test22.java");

       String absPath = file.getAbsolutePath();
       String Path = file.getPath();//File中封装的路径是什么获取到的就是什么。
       String filename = file.getName();
       long size = file.length();
       long time = file.lastModified();

       System.out.println("absPath="+absPath);
       System.out.println("path="+path);
       System.out.print("filename="+filename);
       System.out.println("size+"+size);
       System.out.println("time="+time);

       //毫秒值--Date--格式化--字符串文本
       String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(time));
        System.out.println(str_date);
    }
}

/*
问：
String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(time));
这句话是什么意思？
答:
这行代码的作用是：**将文件的最后修改时间（毫秒值 `time`）格式化为一个人类可读的日期时间字符串**。

分步解析：
1. `new Date(time)`: 将 `time`（毫秒值）转换为 `Date` 对象，代表该时间点。
2. `DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG)`: 获取一个默认语言环境下的日期时间格式化器，日期和时间部分都使用 `LONG` 风格（例如中文环境：`2024年4月26日` 和 `下午02时35分28秒`）。
3. `.format(...)`：将 `Date` 对象格式化为指定风格的字符串。
4. 最终结果赋值给 `str_date`，然后打印。

因此，`str_date` 会输出类似 `2024年4月26日 下午02时35分28秒`（中文环境）的内容，表示文件的最后修改时间。
*/

/*
问：
之前不都是getDateInstance吗？为啥变成getDateTimeInstance了？这两个有什么区别？
答：
两者的区别在于：

- **`getDateInstance()`**：返回的格式化器**只处理日期部分**（年/月/日），不包含时间。例如输出：`2024年4月26日`。
- **`getDateTimeInstance()`**：返回的格式化器**同时处理日期和时间**（年/月/日 + 时/分/秒），例如输出：`2024年4月26日 下午02时35分28秒`。

因此，如果你的需求是只显示日期就用前者，要显示完整的日期时间就用后者。两者都需要传入风格参数（可选），但`getDateTimeInstance`需要两个参数（日期风格和时间风格）。

*/