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
