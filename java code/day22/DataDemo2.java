package day22;

import java.util.Calendar;
import java.util.concurrent.CancellationException;

import javax.management.RuntimeErrorException;

public class DataDemo2 {
    public static void main(String[] args){
        //需求二：基于需求一，获取到了日期和时间的字符串信息（本地）。
        //如何获取字符串中指定的日期信息呢？比如获取年，并判断。
        //1.获取日期对象。Date
//      Date date = new Date();

        // jdk1.1开始 Calendar.//获取日历对象。
        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String week = getCnWeek(c.get(Calendar.DAY_OF_WEEK));

        //打印信息中年月日等相关信息都在这里，获取指定字段的值就可以了。
        System.out.println(year+"年"+month+"月"+day+"日"+week);
    }
    //让星期字段对应的中文的星期。查表。数组。

    public static String getCnWeek(int i){
        if(i<0 || i>7){
            throw new RuntimeException(i+"没有对应的星期");
        }
        //定义表
        
		String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		
        return weeks[i];
    }
}

/*
java.util.GregorianCalendar[time=1382840743546
,areFieldsSet=true,areAllFieldsSet=true,lenient=true
,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai"
,offset=28800000,dstSavings=0,useDaylight=false,transitions=19
,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1
,ERA=1,YEAR=2013,MONTH=9,WEEK_OF_YEAR=44,WEEK_OF_MONTH=5
,DAY_OF_MONTH=27,DAY_OF_YEAR=300,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4
,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=25,SECOND=43,MILLISECOND=546
,ZONE_OFFSET=28800000,DST_OFFSET=0]
*/



/*
问：
这段代码中，	String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};这一行为啥第一个是空着的？

答：
在代码中，Calendar.DAY_OF_WEEK 返回的数值范围是 1（星期日）到 7（星期六），而不是从 0 开始。为了让 i 直接作为索引获取对应的星期字符串，数组 weeks 需要在索引 0 的位置留空（占位），使得：

weeks[1] = "星期日"

weeks[2] = "星期一"

...

weeks[7] = "星期六"

这样 weeks[i] 就能直接得到正确的星期名称，无需做额外的减一操作。如果去掉第一个空字符串，weeks[1] 会变成“星期一”，导致对应关系错位。因此，留空是为了对齐下标。


*/



//4月26日  复习

public class DateDemo2{
    public static void mian(String[] args){
        //需求二：基于需求一，获取到了日期和时间的字符串信息（本地）。
        //如何获取字符串中指定的日期信息呢？比如获取年，并判断。
        //1.获取日期对象。 Date
    //  Date date = new date();

    //      jdk1.1开始 Calendar.//获取日历对象。
        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String week = getCnWeek(c.get(Calendar.DAY_OF_WEEK));

        //打印信息中年月日等相关信息都在这里，获取指定字段的值就可以了。
        System.out.println(year+"年"+month+"月"+day+"日"+week);
    }
    //让星期字段对应的中文的星期。查表，数组。

    public static String getCnWeek(int i){
        if(i<0||i>7){
            throw new RuntimeException(i+"没有对应的星期");
        }
        //定义表

        String [] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return weeks[i];
    }
}


/*
问：
getInstance(); 得到了什么？

答：
简单说：getInstance() 就像在内存中创建了一个“今天的日历本”，你可以翻看它的年、月、日、星期几，也可以修改日期（比如加一天、减一个月），
还能把日期换算成毫秒时间戳。它是 Java 早期处理日期时间的核心工具（在 java.time 包出现之前）。
*/

/*
问：
String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};这段代码中，为啥数组中第一个是星期日？而不是星期一？

答：
这是因为 Calendar 类中定义的 DAY_OF_WEEK 常量值是这样对应的：

1 → 星期日（Calendar.SUNDAY）

2 → 星期一（Calendar.MONDAY）

3 → 星期二

...

7 → 星期六

为了能直接用 weeks[i] 获取正确的星期名称，数组的索引必须与这些数字对齐。
因此 weeks[1] 必须是 "星期日"，weeks[2] 必须是 "星期一"，依此类推。索引 0 没有对应值，所以用空字符串占位。如果数组第一个放 "星期一"，那么 weeks[1] 就会变成星期一，但实际 c.get(Calendar.DAY_OF_WEEK) 返回 1 时代表星期日，就会错位。
所以数组必须按照 Calendar 的约定来设计，即星期日放在索引 1。


*/