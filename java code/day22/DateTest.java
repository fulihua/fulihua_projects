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
