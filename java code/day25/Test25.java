package day25;

/*
【课上笔记】
编码表：其实就是生活中文件和计算机二进制的对应关系表。
1.ascii:一个字节中的7位就可以表示。对应的字节都是正数。0-xxxxxxx
2.iso8859-1:拉丁码表 latin,用了一个字节用的8位。1-xxxxxxx  负数。
3.  GB2312:简体中文码表。6,7千的中文和符号。用两个字节表示。两个字节都是开头为1，两个字节都是负数。
    GBK:目前最常用的中文码表，2万的中文和符号。用两个字节表示，一部分文字，第一个字节开头是1，第二字节开头是0
    GB18030:
4.unicode:国际标准码表：无论是什么文字，都用两个字节存储。Java中的char类型用的就是这个码表。char c = 'a';占两个字节。
          在Java中，字符串是按照系统默认码表来解析的。简体中文版 字符串默认的码表是GBK
5.UTF-8:基于unicode,一个字节就可以存储数据，不要用两个字节存储，而且这个码表更加的标准化，在每一个字节头加入了
            编码信息（后期到api中查找).

能识别中文的码表：GBK UTF-8  正因为识别中文码表不唯一，涉及到了编码解码问题。

对于我们开发而言：常见的编码 GBK UTF-8 IS08859-1
文字--->二进制（数字）：编码
二进制--->文字：编码

---

字符串：String  字节数组：byte[]
字符串--编码（getBytes())-->字节数组
字节数组--编码（new String(byte[]))-->字符串

练习：【面试题】
1，对字符串按照字节数截取，"abc你好" 有5个字符，有7个字节。
按照3个字节截取 abc ，按照四个字节截取 abc和你字的一半，如果出现中文一半舍弃。
请定义一个功能解决这个问题。

2，联通的问题。


--------


TextReader:读取文本
MediaReader:读取媒体数据

抽取共性，形成体系。
Reader
    |--TextReader  read();
    |--MediaReader

需求：
提高读取文件的效果，使用缓冲技术，提供一个读取文本更高效的读取方法。
覆盖TextReader中的方法。建立高效的read方法。所以建立一个TextReader的子类，用以高效的读取。
Reader
|--TextReader
    |--BufferedTextReader
|--MediaReader

需求2：读取媒体数据也想高效，那就同理，也给读取媒体数据的对象派生一个高效子类
Reader
|--TextReader
    |--BufferedTextReader
|--MediaReader
    |--BufferedMediaReader

搞定。

发现了一个小问题，如果Reader中还有读取其他数据的子类，如果要高效，那岂不是还要给这个子类添加一个高效子类吗？
是的。为了给具体的读取数据的对象增加一些功能，是需要通过子类来完成的。
但是这样做，会导致这个继承体系很臃肿！仅仅为了增加一些功能，而进行继承，不建议。

这些子类无非就是需要高效，而且这些高效的功能实现是一致的。就是提供了一个缓冲区而已。
没有必要每一个对象都存在一个功能重复的子类。

干脆，单独定义一个具备这个缓冲功能的对象，哪个子类需要被缓冲，就将哪个子类传递进来。
class BufferedReader extends Reader{
    private []:提供数组。
    BufferedReader(Reader r){ //  对Reader高效就可以了}
    read(){操作的是数组}//高效的读取动作。
}

Reader
    |--TextReader
    |--MediaReader
    |--BufferedReader

    发现这种设计方式减少了继承体系的臃肿，增减了功能，比继承更为灵活。
    这种设计方式单独定义一个名称：装饰设计模式。
    解决问题：给一组类增加功能，避免继承的臃肿，提高灵活。
    注意：装饰类和被装饰类必须所属于同一个体系，通常装饰类都会提供构造函数接收被装饰类对象。
    装饰类通常不单独存在。

    房子  居住();
        |--毛坯楼房 居住(){简陋}
        |--毛坯平房
        |--田园风光房
        |--欧式风格房

    class 田园风光房 extends 房子{
        田园风光房（房子）{
        
        居住(){
            田园风光的居住，惬意！
        }
        
        class 欧式风格房 extends 房子{
		欧式风格房(房子 ){
			
		
		居住(){
			欧式风格的居住，高端大气上档次！
		}
	
    }

    毛坯楼房 x = new 毛坯楼房();
x.居住();普通

//欧式风格房 y = new 欧式风格房(x);

田园风光房 y = new 田园风光房(x);
y.居住();普通惬意

欧式风格房 z = new 欧式风格房(y);
z.居住();普通，惬意，高端大气上档次！

--------------------------------


字节流：
FileInputStream  FileOutputStream
BufferedInputStream  BufferedOutputStream

字符流：
FileReader  FileWriter
InputStreamReader  OutputStreamWriter
BufferedReader  BufferedWriter

所学习的对象都是用于操作文件中数据的对象，可以进行字符编码转换的，有可以提供效率的。


需求：将键盘录入的数据存储到文件中。
System.in.read();//阻塞

IO流中对象很多，解决问题（处理设备上的数据时）到底该用哪个对象呢？**********

把IO流进行了规律的总结（四个明确）：
明确一：要操作的数据是数据源（数据的提供者）还是数据目的（数据的接收者）
    源：InputStream  Reader
    目的： OutputStream Writer
先根据需求明确要读，还是要写。

明确二：要操作的设备上的数据是字节还是文本呢？
    源：
        字节：InputStream
        文本：Reader
    目的：
        字节：OutputStream
        文本；Writer
    已经明确到了具体的体系上。

明确三：明确数据所在的具体设备。
    源设备：
        硬件：文件  File开头
        内存：数组，字符串
        键盘：System.in
        网络：Socket
完全可以明确具体要使用哪个流对象

明确四：是否需要额外功能呢？
    额外功能：
        转换吗？转换流。InputStreamReader  OutputStreamWriter
        高效吗? 缓冲区对象。BufferedXXX
        有多个源（字节流）吗?序列流。SequenceInputStream
        对象需要序列化吗？ObjectInputStream,ObjectOutputStresam 
        需要保证数据输出的表现形式吗？打印流。PrintStream  PrintWriter
        需要操作基本类型数据保证字节原样性吗？DateOutputStream  DateInputStream


------------------------------

五个需求：**********

需求0：将字符串写入到文件中。
明确一：有源吗？有目的吗？
    源：字符串。String ，不用io指定，定义String字符串就可以了。
    目的：文件。使用IO技术，输出流  OutputStream  Writer

明确二：是文本数据吗？
    是
    目的：Writer

明确三：具体设备是？
    目的设备：
        硬盘：File开头的对象 Writer体系中的。
    明确出来，具体要使用的对象是FileWriter

    FileWriter fw = new FileWriter("a.txt");
    fw.write(string);

明确四：需要额外功能吗？
    需要，高效。缓冲区对象。BufferedWriter
BufferedWriter bufw = new BufferedWriter(new FileWriter("a.txt"));
bufw.write(string);
bufw.newLine();
bufw.flush();


-------------------------------------
需求1.复制一个文本文件，有可能对复杂过程中的文本进行过滤
比如将文档中的nba，替换成“美国职业篮球大联盟”写入到目的文件中。

明确一：有源，有目的
    源：InputStream  Reader
    目的：OutputStream Writer

    强调一点：如果仅做复制动作，不需要考虑数据是字节还是文本。直接使用字节流就可以了
    FileInputStream fis = new FileInputStream("a.txt");
    FileOutputStream fos = new FileOutputStream("b.txt");

    但是如果在复杂过程中，需要文本中的字符数据进行操作，必须使用字符流。
明确二：是纯文本数据吗？
    是
    源：Reader
    目的：Writer

明确三：具体设备：
    源设备：
        硬盘：File开头对象 FileReader
    目的设备：
        硬盘：File开头对象 FileWriter

FileReader fr = new FileReader("a.txt");
FileWriter fw = new FileWriter("b.txt");

明确四：需要额外功能吗？
需要，高效
BufferedReader bufr = new BufferedReader(new FileReader("a.txt"));
BufferedWriter bufw = new BufferedWriter(new FileWriter("b.txt"));
String line = bufr.readLine();
line = line.replace("nba","美国职业篮球大联盟")；
bufw.write(line);
bufw.flush();
bufw.close();

------------------------------------------

需求2：读取键盘录入将数据存储到文件中。

明确一：有源，有目的。
    源：InputStream  Reader
	目的：OutputStream Writer
	
明确二：是纯文本数据吗？
	是！
	源：Reader
	目的：Writer
明确三：具体设备：
    源设备：键盘。System.in;
    目的设备：硬盘。FileWriter
InputStream in = System.in;
FileWriter fw = new FileWriter("a.txt");

byte[] buf = new byte[1024];
int len = in.read(buf);
String str = new String(buf,0,len);
fw.writer(str);
这样虽然可以做，但是很麻烦。

明确四：需要额外功能吗？
    需要，转换。因为明确源的体系是Reader。可是具体设备System.in 这是字节流，需要字符流，需要转换功能，
        将字节流转成字符流。字节-->字符  InputStreamReader
    InputStreamReader isr = newInputStreamReader(System.in);
    FileWriter fw = new FileWriter("a.txt");

    还需要额外功能吗？需要，高效。
    BufferedReader bufr = new BufferedReader(newInputStreamReader(System.in));
    BufferedWriter bufw = new BufferedWriter( new FileWriter("a.txt"));

---------------------------------

需求3：读取文本文件打印到屏幕上。
明确一：有源，有目的
    源：InputStream  Reader
    目的： OutputStream  Writer

明确二：是纯文本数据吗？
    是
    源：Reader
    目的：Writer
明确三：具体设备：
    源设备：硬盘，FileReader
    目的设备：屏幕，System.out

FileReader fr = new FileReader("a.txt");
PrintStream out = System.out;
out.println();

其实这样已经完成需求了。
PrintStream对象中有N多的print方法。
fr.read();
System.out.println();
明确四：额外功能。
    BufferedReader bufr = new BufferedReader(new FileReader("a.txt"));
    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

--------------------------------------

需求4：读取文件中的文本数据，将数据按照UTF-8的方式存储到文件中。
明确一：有源，有目的
    源：InputStream  Reader
	目的：OutputStream Writer

明确二：是纯文本数据吗？
	是！
	源：Reader
	目的：Writer
明确三：具体设备：
	源设备：硬盘，FileReader
	目的设备：硬盘，FileWriter

FileReader fr = new FileReader("a.txt");
FileWriter fw = new FileWriter("b.txt");

但是，不符合题中的要求，对于目的要求必须是UTF-8的编码。
所以必须使用额外功能。
明确四：需要额外功能，转换。
FileReader fr = new FileReader("a.txt");//默认编码
OutputStreamWriter osw = new OutputStreamWritere(new FileOutputStream("b.txt"),"utf-8");

还需要其他额外功能吗？需要，缓冲区。
BufferedReader bufr = new BufferedReader(new FileReader("a.txt"));
BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt"),"utf-8"));








*/








/*
问：
源：字符串。String ，不用io指定，定义String字符串就可以了。
    目的：文件。使用IO技术，输出流  OutputStream  Writer
这是什么意思？io技术是啥？

答：
“如果数据来源是内存中的字符串，直接用 String 变量即可，不需要 IO；但如果要把数据存到文件里，就必须用 Java 的 IO 输出流（比如 FileWriter）来写。”

追问：
就是说如果可以直接赋值就不用IO流，其他情况都需要IO流吗？

答：
更准确的说法是：当数据源或数据目的地不是当前程序的内存变量，而是外部设备或持久化存储时，通常就需要使用某种 I/O 技术（在文件场景下就是 Java IO 流）。而对于纯内存操作（如字符串拼接、数组拷贝、集合运算），完全不需要 IO 流。
*/

/*
问：
read(byte[]) 这个方法的意思是将读取到的数据存入byte[]中吗？System.in 的运行时类型是 BufferedInputStream这句话是啥意思？System.in到底是BufferedInputStream的子类还是InputStream的子类？

答：
`read(byte[])` 方法的作用正是：从输入流中读取若干字节，并将这些字节存入你提供的字节数组中（下标从0开始填充）。它返回实际读取的字节个数。

`System.in` 的运行时类型是 `BufferedInputStream`，这句话的意思是：`System.in` 在程序启动时，实际上被 Java 初始化成了一个 `BufferedInputStream` 类型的对象。虽然代码中声明为 `InputStream` 类型（编译时类型），但实际在内存中的对象是 `BufferedInputStream` 的实例。

至于继承关系：`BufferedInputStream` 是 `InputStream` 的子类，因此它拥有 `InputStream` 中定义的所有方法（如 `read(byte[])`），并且进行了自己的实现（加缓冲）。所以 `System.in` 既可以看作 `InputStream`（向上转型），也可以看作 `BufferedInputStream`（向下转型）。

总结：
- `in.read(buf)` 能调用，是因为 `in` 指向的对象（`BufferedInputStream`）实现了 `read(byte[])` 方法。
- `System.in` 实际类型是 `BufferedInputStream`，它是 `InputStream` 的子类。
*/


/*
问：
InputStream in = System.in;
FileWriter fw = new FileWriter("a.txt");

byte[] buf = new byte[1024];
int len = in.read(buf);
String str = new String(buf,0,len);
fw.write(str);这段代码是什么意思？int len = in.read(buf);
String str = new String(buf,0,len);这里我不太理解

答：
我们来解释你问的这两行代码。

### 1. `int len = in.read(buf);`
- `in` 是 `InputStream` 类型，指向 `System.in`（键盘输入）。
- `buf` 是一个 `byte[]` 数组，长度为 1024。
- `in.read(buf)` 会从键盘读取用户输入的数据，将数据存入 `buf` 数组中（以字节形式）。
- 返回的 `len` 是**实际读取到的字节个数**。
    - 例如，你输入 "hello" 并按下回车，实际输入的字节可能是 'h','e','l','l','o','\r','\n'（取决于操作系统），长度可能是 6 或 7。
- 这个方法会阻塞，直到有输入或流结束。

### 2. `String str = new String(buf, 0, len);`
- 这个构造方法将**字节数组的一部分**转换成字符串。
- `buf`：字节数组。
- `0`：从数组的起始位置开始。
- `len`：使用 `len` 个字节（即刚刚实际读到的字节数）。
- 底层会使用**平台默认的字符编码**（例如 Windows 下可能是 GBK，Linux 下可能是 UTF-8）将字节解码成字符。
- 最终得到的 `str` 就是你输入的那段文本（例如 "hello\r\n" 会被解码成带换行的字符串）。

### 整体流程
你运行程序后，程序等待你在控制台输入内容，按回车后：
- 读取你的输入 → 存入 `buf`，得到 `len`。
- 将这部分字节转为字符串。
- 把这个字符串写入到 `a.txt` 文件中。

这样，你输入的内容就被保存到文件中了。

**注意**：这段代码有局限性：
- 只读取一次，最多 1024 字节，超过会截断。
- 使用平台默认编码，当输入中文时可能乱码（建议用 `InputStreamReader` 指定编码）。
- 没有关闭流，可能导致资源泄露（应该用 try-with-resources 或 finally 关闭）。

但就你问的这两行本身，意思就是：**读取键盘输入的一批字节，然后把这批字节转换成字符串**。
*/