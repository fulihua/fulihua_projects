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
