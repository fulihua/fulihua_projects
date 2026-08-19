package day25;

import java.io.IOException;
import java.io.Reader;

/*
自定义一个字符流缓冲区。用于缓冲字符数据，从而提高操作效率。
并提供了更多操作缓冲区数据的方法。需要使用具体的流对象来完成数据的获取。

分析： 缓冲区应该具备什么？1.必须要有数组。2.需要对数组进行操作，对数组操作一定要有角标。
*/
public class MyBufferedReader {
    private Reader r;

    //定义一个字符数组，作为缓冲区。
    private char[] buf = new char[1024];
    //定义一个索引，用于操作数组中的元素。
    private int index = 0;
    //定义一个变量，用于记录读取字符的个数。（缓冲区）
    private int count = 0;

    //需要一初始化就具备一个流对象。
    public MyBufferedReader(Reader r){
        // 可以对Reader的所有子类进行高效读取。
        this.r = r;
    }
    /*
    提供一个可以从缓冲区中读取字符的方法。
    高效方法。
    */
   public int read() throws IOException{
    /*
    1.需要先通过流对象从底层设备上获取一定数据的数据到缓冲区中。使用流对象read(char[]);
    */
   //如果count记录字符个数的变量为0，说明缓冲区已经没有字符数据。
   if(count==0){
    //需要从设备上获取一定数量的数据存储到缓冲区中，并用count记录存储字符的个数。
    count = r.read(buf);
    //每取一次新的数据，就需要将角标归0.
    index = 0;
   }
   //如果count小于0，说明到-1，没有数据了，程序直接返回-1.
   if(count<0){
    return -1;
   }
   //从缓冲区中取出一个字符。
   char ch = buf[index];
   //角标自增。
   index++;
   //计数器要自减。
   count--;

   return ch;
   }

   /*
   基于高效的read方法，建立一个一次可以读取一行的数据的方法。
   将行终止符的数据转成字符串返回。
   */

   public String readLine() throws IOException{
    /*
    思路；
    
    从缓冲区中一次获取一个字符，并将这个字符存储到临时容器中。
    每获取一个字符都要进行判断，只要不是行终止符都进行存储。
    一旦读取到行终止符，就将临时容器中的数据转出字符串返回。
    */
   //1.定义一个临时容器。
   StringBuilder sb = new StringBuilder();

   //2.调用本类中的read方法，从缓冲区中读取一个字符，存储到临时容器中。
   //存的时候要注意：必须判断，如果是行终止符就不要存储了。就将临时容器中的
   //字符转成字符串返回。

   int ch = 0;
   while((ch=this.read())!=-1){
    if(ch=='\r'){
        continue;
    }
    if(ch=='\n'){
        return sb.toString();
    }
    sb.append((char)ch);//将读取到的字符数字转成char类型，存储到sb中。
   }

   //万一文本中最后一行没有行终止符，判断一下sb中是否有内容，如果有则返回。
   if(sb.length()!=0){
    return sb.toString();
   }
    return null;
   }
   //关闭资源。
   public void close() throws IOException{
    //其实内部就是关闭具体的流。
    r.close();
   }
}


/*
问：
stringbuilder是啥？

答：
StringBuilder 是 Java 中一个用于创建可变字符串的类，位于 java.lang 包。它与 String 最大的区别在于：String 是不可变的（每次修改都会创建新对象），而 StringBuilder 是可变的，适用于需要频繁拼接、修改字符串的场景，性能更高。
需要注意的是：StringBuilder 不是集合。它是 java.lang 包下的一个类，用于构建和操作可变字符串。

追问：
那stringbuffer是啥？

答：
StringBuffer 也是 Java 中用于创建可变字符串的类，位于 java.lang 包。它的用法和 StringBuilder 几乎一样，都提供了 append()、insert()、delete() 等方法。

唯一的主要区别：

StringBuffer 是线程安全的（方法用 synchronized 修饰），适合多线程环境。

StringBuilder 是非线程安全的，但性能更高，适合单线程场景。

总结：

StringBuffer = 可变字符串 + 线程安全（慢）

StringBuilder = 可变字符串 + 非线程安全（快）

日常开发中，除非明确需要线程安全，否则优先使用 StringBuilder。
*/

/*
问：
sb.append((char)ch);//将读取到的字符数字转成char类型，存储到sb中。
			这里是什么意思？为啥要将字符数字转成char类型？char不就是字符型吗？还有//万一文本中最后以后没有行终止符，判断一下sb中是否有内容，如果有则返回。
		if(sb.length()!=0){
			return sb.toString();
		}这里我没听懂，sb中不都有内容吗？

答：
1.read() 方法从文件（或输入流）中读取一个字符，返回的是该字符的 Unicode 码点（一个整数，比如 'A' 是 65，'好' 可能是 22909 等）。同时，它用 -1 来表示“已经读到文件末尾，没有更多字符了”。

如果返回类型是 char，它只能表示 0~65535 的正数，无法表示 -1。所以用 int 类型。

因此 int ch 中保存的是字符的数值，或者 -1。

举例：文件中的字符 'A'，读取时 ch 会等于 65（十进制），而不是字符 'A' 本身。


2. 为什么需要 (char)ch 强制转换？
StringBuilder 的 append 方法有很多重载版本：

append(char c)：追加一个字符。

append(int i)：追加一个整数的十进制字符串表示（例如 append(65) 会追加 "65"）。

因为我们希望把读取到的字符本身追加到字符串中，而不是它的数字形式，所以必须调用 append(char) 版本。而 ch 是 int 类型，直接 sb.append(ch) 会调用 append(int)，导致错误。所以需要强制转换为 char：(char)ch，这样就能把数值 65 解释为字符 'A'，追加到字符串中。


3.在 `readLine()` 方法中，`StringBuilder sb` 是在每次调用方法时新创建的局部变量。每次调用 `readLine()` 都会新建一个 `StringBuilder`，因此**它不会自动清空，但每次调用都是全新的**。

- 当读到文件末尾（`ch==-1`）时，如果 `sb` 中已经积累了字符（即最后一行没有换行符），则 `if(sb.length()!=0)` 会触发，返回这最后一行。
- 然后方法结束，该 `sb` 对象失去引用，被垃圾回收。下一次调用 `readLine()` 时，会创建一个新的空的 `StringBuilder`，所以无需手动清空。

所以，你的理解正确：**循环结束后检查 `sb` 是否有内容，是为了处理最后一行无换行符的情况。而 `sb` 本身在每次方法调用中都是新创建的，不需要手动清空。**


*/