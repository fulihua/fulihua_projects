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

//4月29日  复习

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

/*
问：
这个代码是什么意思？

答：
这段代码定义了一个通用的文件名过滤器类 FilenameFilterBySuffix，它实现了 FilenameFilter 接口。与硬编码后缀的 FilenameFilterByJava 不同，这个类可以通过构造函数的参数 suffix 动态指定要匹配的文件后缀名。

成员变量 private String suffix;：存储要匹配的后缀（如 ".java"、".txt"）。

构造函数 public FilenameFilterBySuffix(String suffix)：接收一个后缀字符串，并保存到成员变量中。super() 是调用父类 Object 的无参构造，可以省略。

accept 方法：对于给定的目录 dir 和文件名 name，判断文件名是否以 suffix 结尾，是则返回 true（接受该文件），否则返回 false。
*/

/*
问：
那为啥public class FilenameFilterBySuffix implements FilenameFilter{和public FilenameFilterBySuffix(String suffix){要写两遍啊？

答：
这是因为在 Java 中，**类名** 和 **构造方法名** 必须相同。你看到的两处 `FilenameFilterBySuffix` 分别扮演不同角色：

1. `public class FilenameFilterBySuffix implements FilenameFilter`  
   → 这是**定义类的名称**，说明这个类叫做 `FilenameFilterBySuffix`，并且它实现了 `FilenameFilter` 接口。

2. `public FilenameFilterBySuffix(String suffix)`  
   → 这是**定义构造方法**，它没有返回值，名称必须和类名完全一致。这个构造方法的作用是：当你创建对象时（`new FilenameFilterBySuffix(".java")`），可以传入一个参数 `suffix`，并将其保存到对象的成员变量中，这样后续的 `accept` 方法就能根据这个后缀进行过滤。

如果不写构造方法，只能使用默认的无参构造，那么你就无法指定后缀，这个过滤器也就失去了通用性。

所以两处写法都是必要的，并不是重复。如果你觉得看起来像重复，可以这样理解：**第一行是“标签”（类的名字），第二行是“建造方法”（如何建造一个这种类的对象）**，只是名字恰好相同而已。
*/

/*
问：
那super();
        this.suffix = suffix;这两行有什么作用？

答：
`super();` 是调用父类 `Object` 的无参构造方法。由于 `FilenameFilterBySuffix` 类没有显式继承其他类，父类就是 `Object`。这一行可以省略（编译器会自动添加），但有时为了清晰或习惯保留。它的作用就是先完成父类的初始化（虽然 `Object` 的构造方法不做啥实质性工作）。

`this.suffix = suffix;` 则是将构造方法传入的参数 `suffix` 赋值给当前对象的成员变量 `suffix`。**注意**：成员变量 `suffix` 和方法参数 `suffix` 同名，必须用 `this.suffix` 来区分，否则 `suffix = suffix` 就只是参数自赋值，成员变量不会被赋值。这一行的目的是让过滤器对象记住用户指定的后缀，供后面 `accept` 方法使用。

所以这两行代码共同完成了对象的初始化：先调用父类构造，再把外部传入的后缀保存起来。
*/