package day22;

import java.io.File;
import java.io.IOException;

public class FileMethodDemo2 {
    public static void main(String[] args) throws IOException{
        /*
        File类中的方法2

        对文件或者文件加进行操作。
        */

        File file = new File("e:\\file.txt");

        /*
            创建文件，如果文件不存在，创建true。如果文件存在，则不创建false。如果路径错误，IOException
        */
       boolean b1 = file.createNewFile();
       System.out.println("b1="+b1);

       //删除
       //boolean b2 = file.delete();//注意：不去回收站，慎用。
       //System.out.println("b2="+b2);

       //需要判断文件是否存在。
       //boolean b3 = file.exists();
       //System.out.println("b3="+b3);

       //对目录操作 创建，删除，判断
       File dir = new File("e:\\abx");
       //boolean b4 = dir.mkdirs();//创建多级目录。//dir.mkdirs();
       //System.out.println("b4="+b4);

       boolean b5 = dir.delete();//删除目录时。如果目录中有内容，无法直接删除。
       //只有将目录中的内容都删除后，保证目录为空。这时这个目录才可以删除。
       System.out.println("b5="+b5);

       System.out.println("------判断文件，目录------");
       File f = new File("e:\\javahaha");//要判断是否是文件还是目录，必须先判断存在。
//      f.mkdir();
        f.createNewFile();
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
    }
}


//4月26日  复习

public class FileMethodDemo2{
    public static void main(String[] args) throws IOException{
        /*
        File类中的方法2

        对文件或者文件夹进行操作。
        */

        File file = new File("e:\\file.txt");

        /*
        创建文件，如果文件不存在，创建true，如果文件存在，则不创建false。如果路径错误，IOException
        */

        boolean b1 = file.createNewFile();
        System.out.println("b1="+b1);

        //删除
        //boolean b2 = file.delete();//注意：不去回收站，慎用。
        //System.out.println("b2="+b2);

        //需要判断文件是否存在。
        //boolean b3 = file.exists();
        //System.out.println("b3="+b3);

        //对目录操作 创建，删除，判断
        File dir = new File("e:\\abx");
        //boolean b4 = dir.mkdirs();//创建多级目录。//dir.mkdirs();
        //System.out.pritln("b4="+b4);

        boolean b5 = dir.delete();//删除目录时，如果目录中有内容，无法直接删除。
        //只有将目录中的内容都删除后，保证目录为空。这时这个目录才可以删除。
        System.out.println("b5="+b5);

        System.out.println("-----判断文件，目录------");
        File f = new File("e:\\javahaha");//要判断是否是文件还是目录，必须先判断存在。
//      f.mkdir();
        f.createNewFile();
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
    }
}

/*
问：
这里为啥 File f = new File("e:\\javahaha");明明创建了一个文件了，后面还有些   f.createNewFile();？

答：
你可能会感到困惑：`File f = new File("e:\\javahaha");` 这一行只是创建了一个代表路径 "e:\\javahaha" 的 `File` 对象，它只是内存中的一个 Java 对象，**并没有在磁盘上实际创建任何文件或目录**。

而 `f.createNewFile();` 才是当你需要实际在磁盘上创建一个**物理文件**时所调用的方法。如果 `e:\\javahaha` 这个路径对应的文件原本不存在，调用 `createNewFile()` 会在磁盘上创建一个空文件；如果已存在，则返回 `false` 且不创建。

另外，`f.mkdir()` 是用来创建目录的，但因为被注释掉了，所以此处实际执行的是创建文件。因此，代码的逻辑是：
1. 创建一个 `File` 对象，指向路径 `e:\javahaha`（此时磁盘上还没有该路径）。
2. 调用 `createNewFile()`，在磁盘上真正创建一个名为 `javahaha` 的文件（没有扩展名）。
3. 然后判断该 `File` 对象是否代表文件（`isFile()` 应为 `true`）或目录（`isDirectory()` 应为 `false`）。

总结：**`new File` 是创建对象（内存中的路径表示），`createNewFile` 是实际创建物理文件**。两者缺一不可，不能混淆。
*/

/*
问：
那我什么时候用new File，什么时候用createNewFile呢？还是说要同时出现？

答：
1. new File(String pathname)
作用：在内存中创建一个 File 对象，代表一个路径（文件或目录）的抽象表示。它不会在磁盘上创建任何真实文件或目录。

何时使用：任何时候你想操作一个文件或目录（比如读取、写入、删除、判断是否存在、获取属性等），都需要先创建一个 File 对象。它只是一个“路径名的封装”。

2. createNewFile()
作用：在磁盘上实际创建一个空文件（如果不存在）。它是 File 对象的一个方法。

何时使用：只有当你想创建一个新的空文件时，才需要调用它。如果不需要创建物理文件，就不必调用。

是否需要同时出现？
不需要。很多情况下，你只需要 new File 而不需要 createNewFile。例如：

读取一个已存在的文件：new File("data.txt") 然后使用 FileInputStream 等读取。

删除文件：new File("data.txt").delete()

判断文件是否存在：new File("data.txt").exists()

遍历目录：new File(".").listFiles()

只有在需要创建新文件时，才会在 new File 后调用 createNewFile()（或者使用 FileOutputStream 等也隐式创建）。

总结
new File：始终需要（只要你要用 File 类操作路径）。

createNewFile：仅在明确需要创建新文件时调用。


*/