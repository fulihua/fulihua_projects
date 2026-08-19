package day22;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException{
        //练习2：“2012-3-17”转出日期对象。
        /*
        之前有做过，将一个日期对象转成日期文本字符串这个称之为格式化。
        现在要做的是文本-->日期对象：解析。
        这些都是DateFormat中的功能。

        不同日期风格的文本对应不同的格式器。
        */

        String str_date = "2020年3月17日";

        //日期格式器。DateFormat
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

        Date date = dateFormat.parse(str_date);

        System.out.println(date);

        //这种风格在给定的四种风格中不存在。怎么解析呢？只能使用子类SimpleDateFormat的方法。
        //1.构造函数明确特定风格，2.applyPattern 方法来修改格式模式
        str_date = "2013/3/17 17--13--45";
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd hh--mm--ss");
        Date date2 = dateFormat2.parse(str_date);
        System.out.println(date2);
    }
}


//4月26日  复习

public class DateTest{
    public static void main(String[] args) throws ParseException{
        //练习2:"2021-3-17"转出日期对象。
        /*
        之前有做过，将一个日期对象转成日期文本字符串这个称之为格式化。
        现在要做的是文本-->日期对象：解析
        这些都是DateFormat中的功能。

        不同日期风格的文本对应不同的格式器。
        */

        String str_date = "2020年3月17日";

        //日期格式器。DateFormat
        DateFormat dateformat = DateFormat.getDateInstance(DateFormat.LONG);

        Date date = dateFormat.parse(str_date);

        System.out.println(date);

        //这种风格在给定的风格中不存在，怎么解析呢？只能使用子类SimpleDateFormat方法
        //1.构造函数明确特定风格，2.applyPattern 方法来修改格式模式。
        str_date = "2013/3/17 17--13--45";
        DateFormat dateformat2 = new SimpleDateFormat("yyyy/MM/dd hh--mm--ss");
        Date date2 = dateForamt2.parse(str_date);
        System.out.println(date2);
    }
}


/*
问：dateFormat.parse这个方法是干啥的？

答：
dateFormat.parse(String source) 方法的作用是：将符合当前 DateFormat 对象所定义格式的日期字符串，解析成一个 Date 对象。

例如，如果 dateFormat 是一个 MEDIUM 风格的日期格式化器（中文环境下对应 "2024-4-26"），那么调用 parse("2024-4-26") 就会返回一个表示该日期的 Date 对象（时间部分为 00:00:00）。

如果字符串的格式与格式化器不匹配，或者根本不表示有效日期，则会抛出 ParseException。

它是 format 方法的逆操作：format 将 Date 转成字符串，parse 将字符串转回 Date。

*/

/*
问：
Date和DateFormat 是两个单独的抽象类吗？他们包含的方法功能有什么区别？

答：
你的理解需要稍作修正：Date 不是抽象类，它是一个具体的类（public class Date）。而 DateFormat 是抽象类（public abstract class DateFormat）。

两者的区别与功能
类	    类型	主要功能	                                                                                                        常用方法
Date	具体类	表示一个时间点（精确到毫秒），封装了从1970-01-01 UTC开始的毫秒数。	                        getTime()、setTime(long)、before()、after()、compareTo()，以及许多已过时的日期字段方法（如 getYear()、getMonth() 等）。
DateFormat	抽象类	用于将 Date 对象格式化为日期/时间字符串，或将字符串解析为 Date 对象。支持本地化、风格（FULL、LONG、MEDIUM、SHORT）。	        format(Date)、parse(String)、getDateInstance()、getDateTimeInstance() 等静态工厂方法。

简单总结
Date：存储时间点，用于时间计算、比较、存储。

DateFormat：转换工具，在 Date 和 String 之间做格式化的桥梁。

两者配合使用：先创建 Date（表示某个时刻），然后用 DateFormat 把它变成想要的字符串；或者先用 DateFormat 把字符串变成 Date，再进行后续操作。


*/