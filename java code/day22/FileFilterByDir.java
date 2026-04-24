package day22;

import java.io.File;
import java.io.FileFilter;

/*
过滤文件夹的过滤器。
*/
public class FileFilterByDir {
    public boolean accept(File pathname){
        return pathname.isDirectory();
    }
}
