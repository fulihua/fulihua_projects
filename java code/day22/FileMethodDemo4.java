package day22;

import java.io.File;

public class FileMethodDemo4 {
    public static void main(String[] args){
        /*
        需求2：获取目录中的内容，但是只要.java文件。
        */
       File dir = new File("E:\\Java_code\\day06");

       File[] files = dir.listFiles(new FilenameFilterBySuffix(".JPG"));//需要传递一个文件名过滤器 FilenameFilter对象

       /*
       listFiles源码解析
       public File[] listFiles(FilenameFilter filter){//FilenameFilter filter = new FilenameFilterByJava()
            String ss[] = list();//调用了File类中的list()获取到所有的名称数组 ss.
            if(ss==null) return null;//健壮性判断，如果数组为null，就返回。
            ArrayList<File> files = new ArrayList<>;//创建了一个集合。元素是File类型。
            for(String s:ss)//遍历名称数组。
            {
                if((filter == null)||filter.accept(this,s))//对遍历的名称进行过滤器的判断。将当前目录this，遍历到名称s传递给accept方法。
                    //一旦条件满足过滤器的过滤条件。
                files.add(new File(s,this));//将满足过滤条件添加到集合中。添加是将文件名称和当前目录封装成File对象。new File(dir,name);

                return files.toArray(new File[files.size()]);//将集合转成数组返回。为啥？不需要增删操作。

            }
       }
       */
      for(File file:files){
        System.out.println(file.getName());
      }
    }
}



/*
问：
return files.toArray(new File[files.size()]);//将集合转成数组返回。为啥？不需要增删操作。

            }这段代码中为啥要写[files.size()]？有什么作用？
答：
总结：new File[files.size()] 提供足够容量的数组，让 toArray 直接填充并返回，高效且类型安全。


*/