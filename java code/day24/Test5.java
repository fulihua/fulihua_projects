package day24;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;


public class Test5 {
    	private static final String LINE_SEPARATOR = SeparatorTool.LINE_SEPARATOR;

            public static void main(String[] args) throws IOException{
                //5.获取指定目录下所有的.java文件（包含子目录中的）
                //并将这些Java文件的绝对路径写入到一个文件中。
                //建立一个Java文件清单列表。
                /*
                思路：
                1.一看到包含子目录，必须递归。
                2.写数据到文件 ，输出流。
                3.继续分析，发现只要.java，需要过滤器。
                4.满足过滤的条件的文件有可能非常多，先进行存储。
                */
               //被遍历的目录。
               File dir = new File("E:\\java_code");

               //明确一个过滤器。
               FileFilter filter = new FileFilterBySuffix(".java") ;

               //符合过滤器条件的文件有很多，最好先存储起来，然后再进行操作。
               List<File> list = new ArrayList<File>();
               //获取指定文件清单。
               getFileList(dir,filter,list);
               File destFile = new File(dir,"javaList.txt");
               write2File(list,destFile);
            }

            public static void write2File(List<File> list,File destFile) throws IOException{
                FileOutputStream fos = null;
                BufferedOutputStream bufos = null;
                try{
                        fos = new FileOutputStream(destFile);
                        bufos = new BufferedOutputStream(fos);
                        for(File file:list){
                            String info = file.getAbsolutePath()+LINE_SEPARATOR;
                            bufos.write(info.getBytes());
                            bufos.flush();//每写一个绝对路径就刷新一次。
                        }
                }finally{
                    if(bufos!=null){
                        try{
                            fos.close();
                        }catch(IOException e){
                            throw new RuntimeException("关闭失败");
                        }

                    }
                }
            }
            public static void getFileList(File dir,FileFilter filter,List<File> list){
                File[] files = dir.listFiles();
                for(File file:files){
                    if(file.isDirectory()){
                        getFileList(file, filter, list);
                    }else{
                        //如果是文件，传递到过滤器中去过滤，将满足条件存储起来。
                        if(filter.accept(file)){
                            list.add(file);
                        }
                    }
                }
            }
}


/*
问：
那为啥原代码中的File dir = new File("E:\\java_code");
这个就只传了一个参数，而File destFile = new File(dir, "javalist.txt")却传了两个参数？他们的格式不一样吗？

答：
这是因为 `File` 类提供了多个不同的构造方法（构造器重载），以满足不同的使用场景：

- **`File(String pathname)`**：直接传入一个完整的路径字符串（例如 `"E:\\java_code"`），表示这个文件或目录的绝对路径或相对路径。  
- **`File(File parent, String child)`**：传入一个父目录的 `File` 对象和一个子路径字符串（文件名或相对路径），组合成一个新的 `File` 对象，代表父目录下的某个文件或子目录。

所以两个写法都是正确的，只是构造器参数不同。前者适合已知完整路径，后者适合已知父目录和子路径，便于复用父目录对象，避免字符串拼接。这就是你看到参数个数不一样的原因。

*/

/*
问：
public static void write2File(List<File> list, File destFile) throws IOException {为啥这个函数传参形式感觉和平常不一样呢？平常传参不都是（list, destFile)吗？

答：
其实这个函数的参数列表写法是标准的，和平常完全一样：`(List<File> list, File destFile)` 就是两个参数，第一个参数类型是 `List<File>`，变量名 `list`；第二个参数类型是 `File`，变量名 `destFile`。你看到的“List<File> list”和“File destFile”之间用逗号分隔，这没有什么特别的。可能你之前见过的例子参数类型比较简单（比如 `int a, int b`），这里出现了泛型 `List<File>`，让你感觉不同，但语法规则是一样的。所以不用担心，这是标准的参数列表声明。

追问：
List<File>这个代表啥意思？list是集合的意思，那file又是啥?泛型是啥来着？我又忘了

答：
`List<File>` 表示一个**元素类型为 `File` 的 List 集合**。  
- `List` 是 Java 中的集合接口，代表一个有序、可重复的列表。  
- `<File>` 是**泛型**，它指定了这个列表中只能存放 `File` 类型的对象（不能放其他类型）。  
- `File` 是 Java 中代表文件/目录路径的类。

**泛型**简单来说就是：在定义类、接口或方法时，不指定具体类型，而是用类型参数（如 `<T>`、`<E>`）代替，使用时再明确具体类型。它的好处是增强类型安全，避免强制转换，减少运行时错误。

例如：`List<File> list = new ArrayList<>();` 这样你只能往 `list` 中添加 `File` 对象，取出时也是 `File` 类型，不需要手动转换。

如果你忘了泛型，可以理解为“限定了集合里能装什么东西”。
*/

/*
问：
FileOutputStream fos = null;
		BufferedOutputStream bufos = null。其中FileOutputStream和这个BufferedOutputStream 有什么区别吗？

答：
`FileOutputStream` 和 `BufferedOutputStream` 的主要区别在于**性能和缓冲机制**：

- **`FileOutputStream`**：直接向文件写入字节，每次调用 `write()` 都会触发一次系统调用（写入磁盘），效率较低，尤其在小数据频繁写入时。
- **`BufferedOutputStream`**：内部维护一个字节数组缓冲区。数据先写入缓冲区，当缓冲区满或调用 `flush()` 时才真正通过内层的 `FileOutputStream` 写入磁盘，大大减少了实际磁盘 I/O 次数，提高了性能。

通常用法是将 `BufferedOutputStream` 包装在 `FileOutputStream` 外面：  
```java
FileOutputStream fos = new FileOutputStream(file);
BufferedOutputStream bufos = new BufferedOutputStream(fos);
bufos.write(data);  // 数据进入缓冲区
bufos.flush();      // 强制刷入磁盘
```
关闭流时只需关闭外层的 `bufos`，它会自动关闭内层的 `fos`。

简单比喻：`FileOutputStream` 像亲手一个一个搬砖，`BufferedOutputStream` 像先用小车装一车砖再一起搬。所以后者更快。

追问：
fos = new FileOutputStream(destFile);
                        bufos = new BufferedOutputStream(fos);
                }这一段又是啥意思？  fos = new FileOutputStream(destFile);为啥写的时候要写new FileOutputStream？直接写  fos =destFile;不就好了？下面这个   bufos = new BufferedOutputStream(fos);也有同样的疑问

答：
你的问题根源在于混淆了**对象类型**和**引用变量**。让我们用通俗的比喻解释：

- `destFile` 是一个 `File` 对象，它只是“一个文件的路径描述”（比如一张写有地址的纸条），它**本身不能读写数据**。
- `FileOutputStream` 是一个**专门用来向文件写入字节数据的工具**，它需要知道往哪个文件写，所以构造时必须传入一个 `File` 对象（或路径字符串）。

所以 `fos = new FileOutputStream(destFile);` 的意思是：**创建一个新的 `FileOutputStream` 工具，并让它指向 `destFile` 这个文件，然后把这个工具赋值给变量 `fos`**。  
你不能写 `fos = destFile;` 因为 `destFile` 是 `File` 类型，而 `fos` 是 `FileOutputStream` 类型，两者不兼容（就像你不能把一张纸条直接当成一支笔）。

同理，`BufferedOutputStream` 是一个**带缓冲功能的写入工具**，它需要包装一个基础的 `OutputStream`（比如 `FileOutputStream`）。所以 `bufos = new BufferedOutputStream(fos);` 的意思是：**创建一个新的缓冲工具，让它包装 `fos` 这个基础工具**。同样，不能直接 `bufos = fos`，因为 `fos` 不是 `BufferedOutputStream` 类型。

**总结**：`new` 关键字是用来创建对象的，你不能把一个已存在的对象直接赋值给不同类型的变量，即使它们有继承关系，也必须有明确的创建过程。


追问：
那我可以把BufferedOutputStream理解为是强转吗？

答：
不能理解为强转。强转（如 `(BufferedOutputStream) fos`）要求 `fos` 本身就是 `BufferedOutputStream` 类型或其子类，但 `fos` 是 `FileOutputStream` 类型，两者是兄弟关系（都继承 `OutputStream`），不能直接强转。这里 `new BufferedOutputStream(fos)` 是**创建一个新的 `BufferedOutputStream` 对象**，并将 `fos` 作为参数传入（即包装），而不是类型转换。这是装饰器模式，不是强制类型转换。所以你的理解不对。


追问：
fos = new FileOutputStream(destFile);
			bufos = new BufferedOutputStream(fos);这里是啥意思？为啥要创建两个对象？


答：
FileOutputStream：负责底层字节流，直接与文件交互，将字节写入磁盘文件。它是“慢速”的，每次 write 都会进行系统调用，效率较低。

BufferedOutputStream：是一个缓冲输出流，它内部维护一个字节数组（缓冲区）。当调用 bufos.write() 时，数据先写入缓冲区，等缓冲区满了或手动调用 flush() 时才真正通过 fos 写入文件。这样可以减少实际写入磁盘的次数，大幅提高性能。

为什么要创建两个对象？
因为 BufferedOutputStream 需要包装一个底层的 OutputStream（这里是 FileOutputStream）才能工作。这是一种装饰器模式：在基础流上添加缓冲功能，提升效率。



为什么需要 FileOutputStream 和 BufferedOutputStream 两个东西？
FileOutputStream：就像你直接用一支笔在纸上写字。你写一个字，笔就动一次，效率低。

BufferedOutputStream：就像你先把要写的字放在一个小本子里，写满小本子后再一次性抄到大纸上。这样更省力、更快。

所以先用 BufferedOutputStream 把 FileOutputStream 包起来，这样写数据时先存到缓冲区，等缓冲区满了（或者你主动叫它刷新 flush）才真的写到文件。

代码里每写一行路径就调用 flush()，意思是“赶紧把这行写到文件里，不要等小本子满”。这是为了确保即使程序突然断电，已经写好的行也不会丢失。



总结：

程序 = 搜索所有 .java 文件 → 记下路径 → 写到一个清单文件里。

两个输出流 = 一个负责真正写文件，另一个负责加快写文件的速度。


追问：
那要哪个list集合干啥？直接让list集合代替BufferedOutputStream的作用不就行了吗？

答：List<File> 集合的作用
存储：在递归过程中，先把所有符合条件的 .java 文件临时存到内存的 List 里。这个集合就像一个大袋子，把所有文件对象装起来。

好处：你可以先收集完所有文件，然后再统一处理（比如写入文件）。这样逻辑清晰，也便于后续如果需要对这些文件做其他操作（比如排序、过滤、统计）可以灵活处理。

BufferedOutputStream 的作用
写入：将 List 中每个文件的绝对路径写入到磁盘文件中。它负责的是输出过程，而不是存储。

缓存：它加上 FileOutputStream，是为了提高写入磁盘的效率。没有它也可以直接写，但慢一点。

为什么不能用 List 代替 BufferedOutputStream？
List 只能存在内存中，程序结束就没了。你需要把这些路径永久保存到磁盘，所以必须用输出流。

即使你直接 System.out.println 打印到控制台，那也只是一个临时显示，而不是保存到文件。


*/
	

/*
问：
for(File file : list){
				String info = file.getAbsolutePath()+LINE_SEPARATOR;
				bufos.write(info.getBytes());
				bufos.flush();//每写一个绝对路径就刷新一次。
			}那这里的for(File file : list)的file指的是谁？是desfile吗

答：
`for(File file : list)` 中的 `file` 是**每次从 `list` 集合中取出的一个 `File` 对象**，它代表一个源文件（即符合条件的 `.java` 文件）。而 `destFile` 是目标文件（`javalist.txt`），用于写入结果。两者完全不是同一个东西。所以这里的 `file` 不是 `destFile`。

追问：
？听不懂，告诉我for（）循环括号里面的构成

答：
增强 for 循环的括号内语法是：`(元素类型 变量名 : 要遍历的数组或集合)`。  
在你的代码 `for(File file : list)` 中：
- `File`：元素类型（代表集合中每个元素都是 `File` 对象）
- `file`：循环变量，每次迭代会从 `list` 中取出一个 `File` 对象并赋值给 `file`
- `list`：要遍历的集合，这里是你之前存储所有符合条件的 `.java` 文件的 `ArrayList<File>` 对象。

所以 `file` 不是 `destFile`，而是 `list` 中的每个源文件对象。`destFile` 是目标文件，不在这个循环中。

追问；
file：循环变量，每次迭代会从 list 中取出一个 File 对象并赋值给 file

那你这个file对象的变量名是自己起了一个对吗？是指每次循环里取到的那个文件给他命名为file，对吗？那如果file并不是指destFile，那程序是怎么知道从哪个文件里面进行循环的呢？

答：
你的理解完全正确：

- `for(File file : list)` 中的 **`file`** 是你自己起的变量名，代表每次循环从集合 `list` 中取出的一个元素（即一个 `File` 对象，对应一个源文件）。
- **`list`** 是预先存储了所有符合条件的 `.java` 文件的集合。程序之所以知道要循环哪些文件，就是因为指定了 `list` 这个集合。循环开始时，它会从 `list` 的第一个元素开始，每次取出一个赋值给 `file`，直到遍历完所有元素。
- 这个 `file` 与 `destFile`（目标文件）没有任何关系，`destFile` 是写入的目的地，而 `file` 是被写入的来源信息（例如获取其绝对路径）。

所以，变量名 `file` 是你自定义的，你也可以写成 `for(File f : list)`。关键在于集合变量 `list` 已经包含了所有要处理的对象。

追问：
’哦，所以 destFile是最终存储了.java的那个最终文件，对吗？

答：
不完全对。`destFile` 是**用来存储清单的文件**（例如 `javalist.txt`），它的内容是所有 `.java` 文件的绝对路径列表，而不是 `.java` 文件本身。所以 `destFile` 是**结果文件**（文本文件），不是源代码文件。`.java` 文件是源文件，分散在目录中，而 `destFile` 是最终生成的那个包含路径清单的文件。
*/



/*
问：
public static void write2File(List<File> list,File destFile) throws IOException{
                FileOutputStream fos = null;
                BufferedOutputStream bufos = null;
                try{
                        fos = new FileOutputStream(destFile);
                        bufos = new BufferedOutputStream(fos);
                        for(File file:list){
                            String info = file.getAbsolutePath()+LINE_SEPARATOR;
                            bufos.write(info.getBytes());
                            bufos.flush();//每写一个绝对路径就刷新一次。
                        }
                }finally{
                    if(bufos!=null){
                        try{
                            fos.close();
                        }catch(IOException e){
                            throw new RuntimeException("关闭失败");
                        }

                    }
                }这个代码中，为啥有两个try，一个catch啊？不应该一个try对应一个catch吗？还有为啥这里抛了一个throw new RuntimeException，而catch(IOException e)这个括号里面却不是写的RuntimeException？


答；
你观察得很仔细。这段代码中确实有两个 `try`，但它们的用途不同：

### 1. 外层 `try-finally`
```java
try {
    // 创建流、写数据
} finally {
    // 关闭资源
}
```
这个 `try-finally` 的作用是**保证无论写数据过程中是否发生异常，最终都会执行 `finally` 块中的关闭资源代码**。这属于资源管理的标准模式。

### 2. 内层 `try-catch`（在 `finally` 块内部）
```java
if (bufos != null) {
    try {
        fos.close();
    } catch (IOException e) {
        throw new RuntimeException("关闭失败");
    }
}
```
这个 `try-catch` 只用于**捕获关闭流时可能抛出的 `IOException`**。关闭流可能失败（比如磁盘错误），但关闭失败不影响已经写入的数据（最多资源没释放，但程序马上结束），所以这里**不将异常向上抛出给调用者**，而是捕获后包装成一个非检查型异常 `RuntimeException` 抛出，表示“系统资源关闭失败，属于严重错误，程序终止”。

### 为什么内层 `catch` 括号里是 `IOException`，却抛出 `RuntimeException`？
- `fos.close()` 方法声明抛出 `IOException`（检查型异常），所以必须捕获或继续声明抛出。
- 在 `finally` 块中，我们不想再将检查型异常抛出（否则会覆盖外层可能的业务异常，或者导致方法签名必须声明 `throws IOException`，但这里方法已经声明了 `throws IOException`，其实也可以直接抛，但作者选择转换为非检查型异常，表示这种错误一般不需要调用者处理）。

### 一个 `try` 对应一个 `catch` 的说法
这句话是指：每个 `try` 块可以跟多个 `catch` 块，但这里两个 `try` 是嵌套关系，不是一对一的冲突。所以外层 `try` 没有 `catch`，只有 `finally`；内层 `try` 有 `catch`。这是完全合法的。

### 总结
- 外层 `try-finally`：确保资源关闭。
- 内层 `try-catch`：专门处理关闭资源时的异常，并转换为 `RuntimeException`。
- 这样写是为了避免关闭资源的异常影响主要业务逻辑的正常表达。


追问：
为什么内层 catch 括号里是 IOException，却抛出 RuntimeException？
这个解释我没听懂，简单易懂一点

答：
我们用个生活中的例子来解释：

**场景**：你写了一封重要的信（写入数据），然后要把信放进信封并封口（关闭流）。封口时胶水可能没粘好（抛出 `IOException`），但这封信已经写完了，内容没问题。  

- **`catch (IOException e)`**：就是发现“胶水没粘好”这个具体问题。  
- **`throw new RuntimeException("关闭失败")`**：相当于你对外大声说：“信封封口出问题了！”虽然问题具体是胶水没粘好，但你不想细说，只想告诉别人“封口失败，很严重”。  

为什么要换成 `RuntimeException`？  
- `IOException` 是“检查型异常”，意味着别人调用你的方法时，必须处理这个异常（要么 `try-catch`，要么 `throws`）。但在 `finally` 里关闭资源失败，通常不需要调用者关心，因为主要业务已经完成了。  
- 所以你把 `IOException` 包装成 `RuntimeException`（非检查型异常），调用者可以不用显式处理，但程序会终止，提醒开发者注意。  

简单说：**换了一种异常类型，让异常不再强制别人处理，但程序依然会报错退出**。这样既简化了代码，又不会忽略问题。

追问；
既然想要抛出 RuntimeException，那为啥括号里面不直接写 RuntimeException呢？


答：
我们用一个简单的比喻：

- **`catch` 括号里的类型**：就像你准备了一个“网”，用来接住**某种特定的错误**。  
- **`fos.close()`** 这个方法只会扔出 `IOException` 这种错误（就像它只会扔出苹果）。  
- 所以你必须用一个能接住苹果的网（`catch (IOException e)`）。  
- 如果你用一个接橘子的网（`catch (RuntimeException e)`），就接不住苹果，苹果还是会砸到你头上（编译错误，因为方法没有声明会扔橘子）。

**然后**，你在接住苹果后，你可以决定把它换成橘子扔出去：  
`throw new RuntimeException("关闭失败");`  

**总结**：  
- **括号里写什么** = 你要接什么类型的错误（必须和可能抛出的匹配）。  
- **括号里抛什么** = 你可以选择接住后再扔一个别的类型的错误。  

所以括号里不能直接写 `RuntimeException`，因为 `close()` 不会抛出 `RuntimeException`，你接不住它。

*/



/*
问：
老师上课时说File[] files = dir.listFiles();这一行括号里面不能加过滤器，说什么要的是子目录，加上了就变成文件了？我不懂

答：
关于老师说的“括号里面不能加过滤器”
老师的意思是说：在 dir.listFiles() 的括号里不能加过滤器。即不能写成 dir.listFiles(filter)。

原因：

如果调用 dir.listFiles(filter)，那么返回的数组中只包含那些通过了过滤器的直接子项。

过滤器 filter 是我们用来筛选 .java 文件的（例如 FileFilterBySuffix(".java")）。这个过滤器对于目录也会进行判断：目录名一般不以 .java 结尾，所以目录会被过滤掉，不会出现在数组中。

这样一来，那些包含 .java 文件的子目录因为不满足过滤器条件，就不会被递归遍历，导致子目录中的 .java 文件永远无法被找到。

老师强调的就是：listFiles() 返回的是全部子项，不能因为过滤而丢掉目录。这就是为什么不能加过滤器。
*/