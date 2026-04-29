package day22;

import java.util.Calendar;
public class DateTest3 {
    public static void main(String[] args){
        //4.获取给定年份的2月有多少天？

        for(int year = 2000;year <= 2020;year++)
        {
            show(year);
        }
    }
    public static void show(int year){
        Calendar c = Calendar.getInstance();
        //有获取有设置 set
        //c.set(Canlender.YEAR,2011);
        c.set(year,2,1);
        //时间是连续的，3月1日的前一天就2月的最后一天，知道2月份的天数。

        c.add(Calendar.DAY_OF_MONTH,-1);

       int year1 = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getCnWeek(c.get(Calendar.DAY_OF_WEEK));

        //打印信息中年月日等相关信息都在这里，获取指定字段的值就哦了。
        System.out.println(year1+"年" + month + "月" + day + "日  " + week);
    }
    	public static String getCnWeek(int i) {
		if (i < 0 || i > 7) {
			throw new RuntimeException(i + "没有对应的星期");
		}
		// 定义表。
		String[] weeks = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		return weeks[i];
	}

}


//4月26日  复习

public class DateTest3 {
    public static void main(String[] args){
        //4.获取给定年份的2月有多少天？
        for(int year = 2000;year <= 2020;year++){
            show(year);
        }
    }
    public static void show(int year){
        Calendar c = Calender.getInstance();
        //有获取有设置 set
        //c.set(Calendar.YEAR,2011);
        c.set(year,2,1);
        //时间是连续的，3月1日的前一天就是2月的最后一天，知道2月份的天数。

        c.add(Calendar.DAY_OF_MONTH,-1);

        int year1 = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getCnWeek(c.get(Calendar.DAY_OF_WEEK));

        //打印信息中年月日等相关信息都在这里，获取指定字段的值就可以了。
          //打印信息中年月日等相关信息都在这里，获取指定字段的值就哦了。
        System.out.println(year1+"年" + month + "月" + day + "日  " + week);
    }
    public static String getCnWeek(int i){
        if (i < 0 || i > 7) {
			throw new RuntimeException(i + "没有对应的星期");
		}
		// 定义表。
		String[] weeks = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		return weeks[i];
	}
    }

/*
问：
Calendar c = Calender.getInstance();有什么作用？

答：
`Calendar c = Calendar.getInstance();` 的作用是**获取一个表示当前系统日期和时间的 `Calendar` 对象**。  
- `Calendar` 是一个抽象类，`getInstance()` 是它的静态工厂方法，会根据默认时区和语言环境返回一个具体的子类实例（通常是 `GregorianCalendar`）。  
- 得到的 `c` 对象封装了当前的年、月、日、时、分、秒等信息，并提供 `get`、`set`、`add`、`roll` 等方法用于对日期字段进行操作（例如获取年份、设置月份、增加天数等）。  
- 相比 `Date` 类，`Calendar` 更适合进行日期字段的加减和设置，是 Java 中处理日期时间的重要工具（`java.time` 包出现前尤其如此）。
*/

/*
问：
c.add(Calendar.DAY_OF_MONTH,-1);啥意思？

答:
`c.add(Calendar.DAY_OF_MONTH, -1);` 的意思是将 `Calendar` 对象 `c` 中的日期**减去一天**。

- `add` 是 `Calendar` 类提供的方法，用于对指定的日历字段进行增减。
- 第一个参数 `Calendar.DAY_OF_MONTH` 表示“月份中的天数”字段。
- 第二个参数 `-1` 表示减少 1 天（如果是正数则增加）。
- 这个方法会自动处理跨月、跨年的情况。例如，如果当前是 3 月 1 日，减一天就会变成 2 月 28 日（或 29 日），月份和年份也会相应调整。

因此，这行代码常用于**获取某个月的最后一天**（例如：先设置为下个月的第一天，再减一天，就得到这个月的最后一天）。
*/


/*
问：
您的意思是add会修改day里面的内容？

答：
是的，c.add(Calendar.DAY_OF_MONTH, -1); 这行代码会直接修改 c 对象内部的日期字段，包括 DAY_OF_MONTH，以及自动调整 MONTH 和 YEAR 以保持日期合法。因此，之后调用 c.get(Calendar.DAY_OF_MONTH) 获取的就是修改后的天数（即2月的最后一天）。所以 day 变量确实存储了2月的天数。

*/

/*
问：
c.set(year,2,1);那这句话会修改month里面的内容吗？

答：
是的，c.set(year, 2, 1); 会修改 c 对象中的月份字段（将其设置为 2，即三月份，因为 Calendar 中月份从 0 开始）。这个方法同时会设置年份、月份和日期，之后 c 的内部状态就变成了指定年份的三月一日。所以，它当然会改变 month 的内容。

*/

/*
问：
那最终结果显示的不应该是3月吗？为啥是2月？

答：
关键点在于：`c.set(year, 2, 1)` 中的月份参数 `2` 表示的是**3月**（因为 `Calendar` 中月份从 0 开始：0=1月，1=2月，2=3月）。所以这行代码将日历设置为 **3月1日**。

紧接着 `c.add(Calendar.DAY_OF_MONTH, -1)` 将日期减一天，就变成了 **2月的最后一天**（2月28日或29日）。因此最终获取的月份是 **2月**（`c.get(Calendar.MONTH)` 返回 1，加1后为2）。所以输出显示的是2月，而不是3月。这正是通过“3月1日前一天就是2月最后一天”的技巧来得到2月的天数。
*/

/*
问：
所以set和add的作用到底是什么？

答：
`set` 和 `add` 都是 `Calendar` 类中用于修改日历字段的方法，但行为不同：

- **`set(int field, int value)`**：将指定的日历字段直接设置为给定的值。它不会触发其他字段的自动调整（除非后续调用 `get` 或 `add` 等触发了重新计算）。例如 `c.set(Calendar.MONTH, 2)` 直接将月份设置为 2（即3月），不会根据日期自动调整年份或日期。

- **`add(int field, int amount)`**：在指定的日历字段上增加或减少一个值，并且会自动处理进位/借位。例如 `c.add(Calendar.DAY_OF_MONTH, -1)` 将日期减一天，如果当前是3月1日，减一天后月份会自动变成2月，年份也可能改变（如果是1月1日减一天则年份减一）。

在你的代码中：
- `c.set(year, 2, 1)` 直接设置年、月、日（月份2表示3月）。
- `c.add(Calendar.DAY_OF_MONTH, -1)` 将日期减一天，月份自动回退到2月，从而得到2月的最后一天。

简单总结：**set 是直接赋值，add 是增量修改并自动调整关联字段**。
*/

/*
问：
那为啥不一开始就直接用add呢？

答：
因为你无法直接用 `add` 从任意当前日期“一步到位”得到某年2月的最后一天。  
- 如果你直接使用 `add`，只能相对于当前日期进行偏移，而当前日期是任意的（比如程序运行时的系统时间），无法保证偏移后的结果正好是目标年的2月最后一天。  
- 正确的思路是：**先将日历“跳转”到目标年的3月1日（用 `set` 精确设置），然后通过 `add` 回退一天**，这样就能准确获得2月的最后一天。  
- 先 `set` 再 `add` 是组合用法，各司其职：`set` 用于定位，`add` 用于微调。没有 `set` 的定位，`add` 无法凭空产生目标日期。
*/