package day18;

public class Student {
    private String name;
    private int age;

    public Student()
    {
        super();
    }
    public Student(String name,int age)
    {
        super();
        this.name = name;
        this.age = age;
    }


    //建立学生对象判断相同的依据。覆盖equals方法，只要同姓名同年龄就是同一个人。视为重复元素。

    public String getName()
    {
        return name;
    }

    public boolean equals(Object obj)
    {
        if(this==obj)//比较地址是否相同。
            return true;
        if(!(obj instanceof Student))
        {
            throw new ClassCastException("类型错误");
        }

        Student stu = (Student)obj;//向下转型
        return this.name.equals(stu.name)&&this.age == stu.age;
    }
    public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    public String toString()
    {
        return "Student [name = "+name+ ",age="+age+"]";
    }
}
