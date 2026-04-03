package day19;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo2 {
    public static void main(String[] args) {
		//在创建TreeSet集合对象时明确比较器。
		Set set = new TreeSet(new ComparatorByName());
		/*
		 * 想要按照学生的姓名排序，说明学生中的自然排序不是所需要的。
		 * 这时只能使用比较器。ComparatorByName。
		 */
		set.add(new Student("lisi6",21));
		set.add(new Student("lisi8",22));
		set.add(new Student("lisi5",25));
		set.add(new Student("lisi3",23));
		set.add(new Student("lisi7",20));
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}


