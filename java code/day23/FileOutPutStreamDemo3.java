package day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class FileOutPutStreamDemo3 {
    public static void main(String[] args){
        File file = new File("k:\\file.txt");
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write("abcde".getBytes());
        }catch(IOException e){
            System.out.println(e.toString()+"------");
        }finally{
            if(fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    throw new RuntimeErrorException("");
                }
            }
        }
    }
}


/*
问：public class FileOutputStreamDemo3 {

	
	public static void main(String[] args) {

		File file = new File("k:\\file.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write("abcde".getBytes());

		} catch (IOException e) {
			System.out.println(e.toString() + "----");
		} finally {
         //少了判断fos是否为空的判断语句！！！
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException("");
				}
			}

	}


这段代码中，为啥运行结果显示空指针？老师说是因为没有k盘，所以File file = new File("k:\\file.txt");这一步时根本没有生成文件。但是我记得不是说new一个文件时，没有文件就会生成一个文件吗？

所以你的意思是不是因为没有文件系统还没有生成对应的文件，而是说文件的路径不正确，导致系统无法生成一个新文件，对吗？


答：
是的，你总结得很对。**不是因为“文件系统没有生成文件”，而是因为“路径无效（K盘不存在）”，导致无法创建输出流对象**。具体原因如下：

1. **`new File("k:\\file.txt")`**：这行代码只是创建了一个代表路径的 `File` 对象，**它不会去检查磁盘是否存在，也不会创建任何物理文件**。即使 K 盘不存在，这行代码也不会报错，只是造了一个“空壳”对象。

2. **`new FileOutputStream(file)`**：这一步才真正尝试在磁盘上创建文件。它要求：
   - 父目录（这里是 `k:\`）必须存在。
   - 如果没有父目录，或者路径无效（如磁盘不存在），就会抛出 `FileNotFoundException`。

3. 因为 K 盘不存在，所以 `new FileOutputStream(file)` 抛出了异常，导致 `fos` 变量没有被成功赋值，保持为 `null`。

4. 随后执行 `finally` 块时，`fos.close()` 对 `null` 调用方法，就产生了 **`NullPointerException`**（空指针异常）。

所以，不是你想象的“文件会自己生成”，而是**父目录必须存在**，程序才能创建文件。正确的说法是：**用 `FileOutputStream` 写入文件时，如果文件不存在且父目录存在，它会自动创建文件；但如果父目录也不存在，就会抛出异常**。
*/