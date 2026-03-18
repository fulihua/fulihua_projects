package day17;

public class Person implements Comparable{
    private String name;
    private int age;
    
    public Person()
    {
        super();//super() 在这里是调用父类的构造方法。
        //所以这行代码的作用就是让 Person 对象在创建时先初始化父类（Object）的部分，然后再执行自己的构造代码（这里没有额外代码）。
    }
    public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
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
	
	
	/**
     * 建立了Person对象判断是否相同的依据，只要是同姓名同年龄的就是一个人。
     */

    public boolean equals(Object obj)
    {
        if(this == obj)//在 Java 中，this 是一个隐式引用，指向当前对象，即调用该方法的那个实例。
        //在实例方法中，this 是隐式存在的，可以省略，但遇到同名冲突时必须显式使用。

        //在静态方法中，不能使用 this。
        return true;
        if(!(obj instanceof Person))
        {
            throw new ClassCastException("类型错误");
        }
        Person p = (Person)obj;

        return this.name.equals(p.name) &&this.age == p.age;
    }


    //比较年龄大小的方法。


    public String toString()
    {
        return "Person [name="+name +",age="+age + "]";
    }
    public int compareTo(Object o)
    {
        if(!(o instanceof Person)){
			throw new ClassCastException("类型错误");
		}
        Person p = (Person)o;
        /*
		if(this.age > p.age)
			return 1;
		if(this.age < p.age)
			return -1;
		return 0;*/
		return this.age - p.age;
		
    }
}
