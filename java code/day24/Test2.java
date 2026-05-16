package day24;

import java.io.File;

public class Test2 {
    public static void main(String[] args){
        //2.请删除一个带有内容的目录。
        /*
            思路：1.删除一个带有内容的目录原理：必须从里往外删。
            2.到底有多级目录不确定，递归。
         */
        File dir = new File("E:\\test");
        //System.out.println(dir.delete());

        removeDir(dir);

    }

    //删除一个目录
    public static void removeDir(File dir){
        //1.列出当前目录下的文件以及文件夹File[]
        File[] files = dir.listFiles();//如果目录是系统级文件夹，Java没有访问权限，那么会返回null数组。最好加入判断，
        if(files != null){
            //if(files.length == 0){
            //dir.delete();
            //return;
            //}

            for(File file:files){
                //2.对遍历到的file对象判断是否是目录。
                if(file.isDirectory()){
                    removeDir(file);
                }else{
                    System.out.println(file+":"+file.delete());//删除文件，用打印语句验证是否删除成功，是否出现了误删操作。
                }
            }
        }
        System.out.println(dir+":"+dir.delete());
        
    }
}


/*
问：
这个代码中，if (file.isDirectory()) {
					removeDir(file);这里我不明白

答:
在代码中，`if (file.isDirectory()) { removeDir(file); }` 的含义是：当遍历到的 `File` 对象是一个目录时，就**递归调用 `removeDir` 方法**，
先删除这个子目录内部的全部内容（包括子目录及其文件），然后再回到当前循环，继续处理其他文件或目录。这样能够保证“从最里层开始删除”，逐步向外，最终删除整个目录树。
如果没有这个递归，程序只能删除当前目录下的文件，而无法处理嵌套的子目录。

追问：
就是说当遍历到的file对象是目录时，就继续打开这个目录吗？看下一层是不是文件？如果是文件就删，不是文件就继续打开这个目录吗？

答:
是的，你的理解完全正确。当 `file` 是一个目录时，程序会再次调用 `removeDir(file)`，即**进入这个子目录**，重复同样的过程：列出该子目录下的所有内容，对每个条目判断是否为目录——如果是，继续递归进入；
如果是文件，直接删除。这样会一层一层深入，直到最内层没有子目录，只剩下文件，删除所有文件后，再逐层退出，删除空目录。这就是递归删除的原理。

追问：
file.isDirectory()这个代码不是判断是否是目录的吗？那打开目录的操作在哪里写呢？

答：
在代码中，**打开目录**的操作并没有单独的函数，而是通过 `listFiles()` 方法来获取目录下的所有内容（文件和子目录）。当程序调用 `removeDir(dir)` 时，它首先执行 `dir.listFiles()`，这相当于“打开”该目录，获取其中的条目。
然后，对于每一个条目，如果是目录，就递归调用 `removeDir(file)`，也就是进入这个子目录，再次执行同样的过程（再次 `listFiles` 等）。因此，打开目录的操作就是通过 `listFiles()` 隐含完成的，不需要显式写出“open”之类的语句。
你的理解是正确的：当遇到子目录时，就递归进入，继续遍历下一层。
*/


/*
问：
// if(files.length == 0){
			// dir.delete();
			// return;那这里老师说是看文件长度是否为0，但是这要怎么看啊？如果一个文件夹里面既又文件又有文件夹的话，它的长度是多少？我不明白这个长度是怎么测量的？

答：
这里 files 是通过 dir.listFiles() 获取的 File[] 数组，代表目录 dir 下的直接子项（包括文件和子目录）。files.length 就是这些直接子项的数量。

如果 files.length == 0，说明该目录下没有直接的文件或子目录，即目录是空的。此时就可以直接删除这个空目录（dir.delete()），并且 return 结束当前递归，不再向下执行。

如果目录下既有文件又有文件夹，那么 files.length 就是这些子项的个数（例如 5 个文件 + 3 个子目录，长度就是 8）。因为长度不为 0，所以不会进入这个 if 分支，而是继续执行后面的循环，递归删除子项。

总结：这里的“长度”不是文件的大小，而是子项的数量。通过判断 files.length 是否为 0，可以快速识别空目录并直接删除，避免不必要的循环。但在完整的递归删除逻辑中，即使不写这段判断，循环也能处理（循环会遍历子项，但若没有子项，循环体不执行，最后删除目录）。
注释掉可能是为了演示另一种写法，或者因为递归已经能覆盖所有情况。

追问：
所以files.length == 0并不是指这个文件夹下的内容有多少字，而是值这个文件夹下的文件和文件夹的总共数量有多少，对吗？

答：
是的，你的理解完全正确。`files.length == 0` 表示该目录下**没有任何文件和子目录**（即空目录），而不是指文件内容的大小或字符数。`files` 数组的每个元素代表一个直接子项（文件或文件夹），`length` 就是这些子项的总个数。
*/

/*
问：
if (files != null) {那为啥要加这个判断？

答：
`if (files != null)` 判断是为了避免空指针异常。`dir.listFiles()` 在以下情况会返回 `null`：
- 目录不存在；
- 路径不是目录；
- 因权限问题（如系统目录）无法访问；
- 发生 I/O 错误。

如果不加判断，当 `files` 为 `null` 时，后续的 `for (File file : files)` 或 `files.length` 都会抛出 `NullPointerException`，导致程序崩溃。因此，这个判断是必要的健壮性检查，确保只有当目录正常可读时才继续操作。


追问：
那files != null和file.exist的作用不就相同了吗？

答：
不完全相同。`file.exists()` 只判断文件或目录是否存在，但不能保证 `listFiles()` 一定返回非 `null`。例如：
- 如果 `file` 是一个文件而不是目录，`exists()` 返回 `true`，但 `listFiles()` 返回 `null`。
- 如果目录存在但没有读取权限，`exists()` 返回 `true`，`listFiles()` 仍然返回 `null`。
因此，`files != null` 是针对 `listFiles()` 调用结果的专门判断，用于确保目录可读且不是文件，比 `exists()` 更精确地保障后续遍历安全。通常的健壮写法是：
```java
if (dir.exists() && dir.isDirectory()) {
    File[] files = dir.listFiles();
    if (files != null) {
        // 遍历
    }
}
```
*/