package day22;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args){
        
        long time = System.currentTimeMillis();
//       System.out.println(time);
//        怎么能将这个时间转为我们所熟悉的时间呢？
//         通过另请参阅找到Date类，发现日期对象一初始化可以传递一个毫秒值。


        time = 1382837734218l;
        //创建了一个日期对象，将已有的毫秒值进行封装。通过日期对象的方法获取其中的相关信息。比如年月日。
        Date date = new Date(time);
        System.out.println(date.toString());//Sun oct 27 09:35:34 CST 2013

        //对象的方法已过时，通过toString获取了国际化的信息。如何让信息本土化。
        //toLocaleString()已过时，通过查询信息发现代替从JDK 1.1 开始，由 DateFormat.format(Date date)取代。
        //要格式化一个当前语言环境下的日期，可使用某个静态工厂方法：myString = DateFormat.getDateInstance().format(myDate);

        //在获取格式器对象时可以明确风格。 Full,LONG,MEDIUM(默认风格)和SHORT
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);

        //调用format方法对日期对象进行格式化。用默认风格。
        String str_date = dateFormat.format(date);
        System.out.println(str_date);

}
}

/*
问：
作用：创建一个 同时包含日期和时间 的格式化器。你咋知道这个是同时包含日期和时间的？DateFormat.LONG, DateFormat.LONG);
后面这俩不是一样的吗？
答：
你问得很好。这是因为 方法名本身就决定了它包含日期和时间：

getDateInstance → 只包含日期

getDateTimeInstance → 同时包含日期和时间

即使两个参数都是 DateFormat.LONG，也只是说明日期的风格是 LONG、时间的风格也是 LONG。
两个参数可以不同，比如 getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM)，但无论如何，它都会同时格式化和输出日期与时间两部分。
所以，不是通过参数相同来判断，而是通过方法名 getDateTimeInstance 来判断。
*/


/*
问：
getDateInstance → 只包含日期

getDateTimeInstance → 同时包含日期和时间

那他俩的结果是什么样的？

答：
getDateInstance → 只有日期（年月日等），没有时间（时分秒）。

getDateTimeInstance → 日期 + 时间（具体格式由风格参数决定）。

*/

/*
问：
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);为啥第一个需要写DateFormat，而第二个却不用写DateFormat，直接就是dateFormat？

答：
第一行：DateFormat dateFormat = ... 是声明变量（告诉编译器 dateFormat 是 DateFormat 类型）并同时赋初值。
第二行：dateFormat = ... 是对已经声明过的变量进行重新赋值，所以不需要再写类型 DateFormat。如果写了 DateFormat dateFormat = ... 就会编译错误，因为重复定义变量。

简单说：一个变量在一个作用域内只能声明一次，赋值可以多次。

*/

/*
问：
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);那如果这一行我写成这样呢？DateFormat dateFormat = DateFormat.getDateInstance();它输出的格式是不是和MEDIUM的风格一样呢？

答：
是的，DateFormat.getDateInstance() 无参版本等同于 DateFormat.getDateInstance(DateFormat.MEDIUM)，因此输出的日期格式是 中等风格（MEDIUM）。
例如在中文环境下，会输出类似 2024-4-24 的格式。这与显式指定 MEDIUM 的结果完全一致，也是默认风格。


*/


//4月26日  复习
public class DateDemo {
    public static void main(String[] args){
        
        long time = System.currentTimeMillis();
//       System.out.println(time);
//        怎么能将这个时间转为我们所熟悉的时间呢？
//         通过另请参阅找到Date类，发现日期对象一初始化可以传递一个毫秒值。


        time = 1382837734218l;
        //创建一个日期对象，将已有的毫秒值进行封装。通过日期对象的方法获取其中的相关信息。比如年月日。
        Date date = new Date(time);
        System.out.println(date.toString());//Sun oct 27 09:35:34 CST 2013

        //对象的方法已过时，通过toString获取了国际化的信息。如何让信息本土化？
        //toLocaleString()已过时，通过查询信息发现代替从JDK1.1开始，由DateFormat.foromat(Date date)取代。
        //要格式化一个当前语言环境下的日期，可使用某个静态工厂方法：myString = DateFormat.getDateInstance().fomat(myDate);
        //在获取格式器对象时可以明确风格。Full,LONG,MEDUIM(默认风格)和SHORT
        DateFormat dateFormat = DateFormate.getDateInstance(DateFormat.Full);
        dateForamt = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);

        //调用format方法对日期进行格式化，用默认风格。
        String str_date = dateFormat.format(date);
        System.out.println(str_date);
    }
}



/*
问：
long time = System.currentTimeMillis();
}这一句话是什么意思？为什么是long型的数据？

答：
long time = System.currentTimeMillis(); 这行代码的作用是获取当前系统时间的毫秒数，并赋值给 long 类型的变量 time。

返回值之所以是 long 类型，是因为这个毫秒数非常大（例如现在大约在 1.7×10^12 毫秒级别），已经远远超过了 int 类型的最大值（约 21 亿）。
使用 long（64 位）可以确保数值不会溢出，能够正确表示未来很长时间的时间戳。

*/

/*
问：
 Date date = new Date(time);这一句是干啥的？

 答：Date date = new Date(time); 这一句的作用是：根据给定的毫秒值 time 创建一个 Date 对象。

time 是一个 long 型数值，表示从 1970 年 1 月 1 日 00:00:00 UTC 开始到某个时间点经过的毫秒数。

new Date(time) 会调用 Date 类的有参构造方法，将这个毫秒值转换成对应的日期和时间，并封装成 Date 对象。

这样，你就可以使用 Date 对象的方法（如 getYear()、getMonth()、toString() 等）来获取该时间点的具体日期信息，或者将其格式化成可读的字符串。

同时，Date 对象的方法包括 toString()。
*/

/*
注意：DateFormat.getDateInstance的类型是DateFormat类型。

总结：变量 dateFormat 的类型是 DateFormat，因为它要存储的是格式化器对象，而不是格式化后的结果字符串。结果字符串需要再调用 format() 才能得到！！！
*/


/*
总结对比
代码	                                                右边表达式的类型	变量类型	用途
myString = DateFormat.getDateInstance().format(myDate)	String	                String	  直接得到格式化后的日期字符串
dateFormat = DateFormat.getDateInstance(DateFormat.FULL)  DateFormat	  DateFormat	获取格式化器对象，后续可多次调用 format()
因此，注释中写 myString = ... 是因为它已经执行了 format，结果自然是字符串；而后面单独声明 dateFormat 变量时还没有格式化，所以类型是 DateFormat。


*/
