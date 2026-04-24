package day22;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterByJava implements FilenameFilter{
    public boolean accept(File dir,String name){
        //System.out.println(dir+":::"+name);
        return name.endsWith(".java")
    }
}
