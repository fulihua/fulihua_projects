package day21;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(){
        super();
    }
    public Student(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }
    public String getNamee(){
        return name;
    }    
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+age;
        result = prime*result+((name==null)?0:name.hashCode());
    }
}
