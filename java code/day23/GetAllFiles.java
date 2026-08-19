package day23;

import java.io.File;

public class GetAllFiles {
    public static void main(String[] args){
        /*
        File类的listFiles()列出当前目录下文件以及文件夹。

        需求：能不能列出当前目录下的子目录中的所有内容？
        思路：1.在遍历当前目录时，会获取到当前的所有的文件以及文件夹。
        2.要遍历子目录需要对获取到的当前的file对象进行判断，只有是目录才可以作为子目录进行继续遍历。
        */

        File dir = new File("E:\\test");

        listAll(dir);
    }

    public static void listAll(File dir){

        System.out.println("dir:"+dir.getName());
        File[] files = dir.listFiles();
        for(File file:files){

            if(file.isDirectory()){
                //如果遍历到当前的file对象是个目录，继续遍历。
                listAll(file);
            }else{
                System.out.println("file:"+file.getName());
            }
        }
    }
}
