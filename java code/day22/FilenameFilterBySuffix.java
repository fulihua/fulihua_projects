package day22;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterBySuffix implements FilenameFilter{
    
    private String suffix;

    public FilenameFilterBySuffix(String suffix){
        super();
        this.suffix = suffix;
    }
    public boolean accept(File dir,String name){
        return name.endsWith(suffix);
    }
}
