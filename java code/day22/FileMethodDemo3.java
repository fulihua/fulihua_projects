package day22;
import java.io.File;
public class FileMethodDemo3 {
    public static void main(String[] args){
        //需求：对给定的目录获取内部的内容
        File dir = new File("e:\\java_code");
        //健壮性判断：1、必须是存在的2.必须是目录，否则容易引发返回数组为null，出现NullPointerException
        String[] names = dir.list();//获取的是目录下的当前的文件以及文件夹代的名称。
    //  System.out.println(names);
        for(String name:names){
    //  System.out.println(names);
        }

        File[] files = dir.listFiles();//获取目录下当前文件以及文件对象。
        for(File file :files){
        System.out.println(file.lastModified());
        }
    }
}
