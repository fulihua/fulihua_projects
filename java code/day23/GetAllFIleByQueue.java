package day23;

import java.io.File;
import java.util.LinkedList;

public class GetAllFIleByQueue {
    public static void main(String[] args){
        /*
        遍历文件夹，不用递归咋办？
        思路：
        1.可以通过对每一个目录进行for循环，但是目录层级很多，for循环效率低。
        2.每遍历到一个目录，不对其进行遍历，而是先临时存储起来，相当于把所有目录（无论是否同级）都存储起来。
        3.遍历容器时取到就是目录，然后对目录遍历即可。
        4.从容器中取到目录遍历时发现内部还有目录，一样将这些目录存储到容器中。
        5.只要不断的遍历这个容器就可以了。

        通过图解：发现这个容器只要是一个简单的队列就可以解决这个问题。
        为什么呢？
        首先确定这个容器必须是集合，因为个数不确定。
        然后选择collection还是map呢？选择collection就可以了，用单例就足够了。
        最后选择list还是set呢？选择list，因为看到老师的目录下有同名的文件夹，而set不允许同名，还有我们想要实现遍历完一个文件夹后，就让它弹栈，
        那么我们就需要实现先进先出的功能，而这正好是list的功能。
        */

        File dir = new File("E:\\test");
        System.out.println(dir.getName());
        Queue<File> queue = new Queue<File>();

        //1.对dir进行当前目录的遍历。
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                queue.myAdd(file);
            }else{
                System.out.println(file.getName());
            }
        }
        System.out.println("----------------------------");
        //3.遍历队列容器，因为子目录都在队列中。
        while(!queue.isNull()){

            File subDir = queue.myGet();//从队列中取出子目录。
            System.out.println(subDir.getName());
            //4.遍历子目录。
            File[] subFiles = subDir.listFiles();
            for(File subFile : subFiles){
                if(subFile.isDirectory()){
                    //如果子目录中还有子目录，继续存储到队列中。
                    queue.myAdd(subFile);
                }else{
                    System.out.println(subFile.getName());
                }
            }
        }
    }
}

/*
队列结构，先进先出。
*/

class Queue<E>{
    private LinkedList<E> link;

    /*
    提供了构造队列对象的构造器。
    */
   public Queue(){
    link = new LinkedList<E>();
   }

   /*
   添加元素的方法。
   */
  public void myAdd(E obj){
    link.addFirst(obj);
  }
  /*
  获取的方法。
  */
  public E myGet(){
    return link.removeLast();
  }
  /*
  判断队列是否有元素。
  */
 public boolean isNull(){
    return link.isEmpty();
 }

}