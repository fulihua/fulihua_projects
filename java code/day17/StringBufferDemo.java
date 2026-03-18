package day17;

public class StringBufferDemo {
    
    public static void main(String[] args)
    {
        /**
         * StringBuffer:
         * 1.是一个字符串缓冲区，其实就是一个容器。
         * 2.长度是可变的，任意类型都行。注意：是将任意数据都转成字符串进行存储。
         * 3.容器对象提供很多对容器中数据的操作功能，比如：添加，删除，查找，修改。
         * 4.必须所有的数据最终变成一个字符串。
         * 和数组最大的不同就是:数组存储可以单独操作每一个元素，每一个元素都是独立的。
         * 字符串缓冲区，所有存储的元素都被转成字符串，而且最后拼成了一个大的字符串。
         * 
         * 可变长度数组的原理：新建数组，并复制数组元素到新数组中。
         */

        //1.创建一个字符串缓冲区对象。用于存储数据。
        StringBuffer sb = new StringBuffer();

        //2.添加数据。不断的添加数据后，要对缓冲区的最后的数据进行操作，必须转成字符串才可以。
        String str = sb.append(true).append("hello").toString();
        //sb.append("haha");

        //sb.insert(2."it");//插入

        //sb.delete(1,4);//删除

        //sb.replace(1,4,"cast");
        //ab.setLength(2);
        System.out.println(sb);

        //String s = "a"+5+'c';//原理就是以下这句
        //s = new StringBuffer().append("a").append(5).append('c').toString();
    }

}
