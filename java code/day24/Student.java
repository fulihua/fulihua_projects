package day24;

public class Student implements Comparable<Student> {
    private String name;
    private int cn,en,ma;
    private int sum;
    public Student(){
        super();
    }
    public Student(String name,int cn,int en,int ma){
        super();
        this.name = name;
		this.cn = cn;
		this.en = en;
		this.ma = ma;
		this.sum = cn + en + ma;
    }
    public int compareTo(Student o){
        int temp = this.sum - o.sum;
        return temp == 0?this.name.compareTo(o.name):temp;
    }
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+cn;
        result = prime*result+sum;
        return result;
    }
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        Student other = (Student) obj;
        if(cn!=other.cn)
            return false;
        if(sum!=other.sum)
            return false;
        return true;
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCn() {
		return cn;
	}
	
	public void setCn(int cn) {
		this.cn = cn;
	}
	public int getEn() {
		return en;
	}
	public void setEn(int en) {
		this.en = en;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	

    public String toString(){
        return "Student[name="+name+",sum="+sum+"]";
    }
}


/*
问：
为什么有一个 equals 还有一个 compareTo？

答：
equals：定义两个对象是否相等（逻辑相等）。通常用在 HashSet、HashMap 中判断重复元素。

compareTo：定义对象的排序顺序（例如按总分从高到低）。通常用在 TreeSet、TreeMap 以及排序算法中。
*/

/*
问：
ashCode 方法通过相同的字段计算一个整数，保证如果 equals 返回 true。你不是说equals里面没用到result吗？

答：
用户理解混淆了“保证”的含义。`equals` 方法内部确实不会调用 `hashCode`，也不会用到 `result`。所谓的“保证”是指：作为代码的编写者，你**必须**实现 `equals` 和 `hashCode` 使得它们逻辑一致。
当你重写 `equals` 基于某些字段（如 `cn`, `sum`）判断相等时，你也**必须**重写 `hashCode` 用**同样的字段**计算哈希值。这样，如果 `equals` 返回 `true`，则两个对象的这些字段值相同，因此 `hashCode` 计算出的整数必然相同。
这个“保证”是编程约定，不是 Java 自动执行的，所以 `equals` 方法中不必出现 `hashCode` 相关代码。你的 `equals` 没有比较 `result` 是正确的，因为 `result` 只是 `hashCode` 方法内部的临时变量，不是对象的属性。
`hashCode` 的作用就是产生一个整数，用于哈希集合的快速查找，而不是用于 `equals` 的比较。

追问：
因此 hashCode 计算出的整数必然相同。这个“保证”是编程约定。这句话我明白，但你又说hashCode 的作用就是产生一个整数，用于哈希集合的快速查找，这里我不明白？不是说hashCode 计算的就是哈希值吗

答：
你理解正确：`hashCode` 计算出来的整数就是哈希值。这个哈希值的作用就是**让哈希集合（如 `HashSet`、`HashMap`）能够快速找到对象的位置**。

打个比方：图书馆有成千上万本书。如果你要找一本书，一本一本地翻太慢。于是管理员给每本书按书名首字母分配一个书架（A 架、B 架……）。你想找《西游记》就直接去 X 架找，不用看其他书架。这里的“首字母”就像**哈希值**，书架就像**哈希桶**。

- `hashCode` 方法就是负责计算“首字母”（整数值）。
- `HashSet` 会根据这个值决定把对象放到哪个桶里。
- 查找时也直接用这个值定位桶，然后只在该桶内比较（用 `equals`）。

所以，“用于哈希集合的快速查找”就是指：**通过哈希值跳过绝大多数元素，直接定位到一小块区域，然后在其中用 `equals` 精确匹配**。这就是哈希集合高效的原因。

而“保证 `equals` 为 `true` 时 `hashCode` 相等”是为了确保：如果两个对象相等，它们必须被放在同一个桶里，否则你就找不到它。这就是为什么重写 `equals` 必须重写 `hashCode`。

总结：
- **`hashCode` 返回哈希值**（一个整数）。
- **哈希集合用这个整数快速定位桶**，实现快速查找。
- **两个相等的对象必须产生相同的哈希值**，否则集合会错乱。

希望这个解释让你彻底明白。
*/

/*
问：
Student other = (Student) obj;这一句是啥意思？最后末尾这一句return true;是不是多写了？

答：
在你的 `equals` 方法中，最后一句 `return true;` 不是多写的。前面的代码已经判断了所有不相等的情况（比如地址不同、类型不同、字段不同），如果都通过了，就意味着两个对象在业务上是相等的，所以返回 `true`。如果没有这句，方法就没有返回值，编译会报错。

`Student other = (Student) obj;` 是将 `obj` 强制转换为 `Student` 类型，以便能够访问 `Student` 的私有成员 `cn` 和 `sum`。因为 `obj` 是 `Object` 类型，不能直接访问子类的字段。

追问:
Student other = (Student) obj; 是将 obj 强制转换为 Student 类型，以便能够访问 Student 的私有成员 cn 和 sum。因为 obj 是 Object 类型，不能直接访问子类的字段。

那为啥又突然冒出个other？前面几句咋不用？
在你的 equals 方法中，最后一句 return true;那他为啥不加else？我哪里知道那一句通过返回true？


答：
在 `equals` 方法中，`Student other = (Student) obj;` 这行代码的作用是**将 `Object` 类型的参数 `obj` 强制转换为 `Student` 类型，并赋值给局部变量 `other`**。
之后就可以通过 `other.cn` 和 `other.sum` 访问 `Student` 类的私有字段，用于比较。前面的几个判断（`this == obj`、`obj == null`、`getClass()` 比较）都不需要访问 `Student` 的特定字段，所以不需要转换。

最后一句 `return true;` **不是多写的**。它的执行条件是：所有前面的判断都没有返回 `false`，即两个对象引用不同、`obj` 非空、类型相同、`cn` 相等、`sum` 相等。这种情况下，程序会执行到这一行，返回 `true`，表示两个对象内容相等。
注意，前面的每个 `if` 块如果条件成立都会立即 `return false` 或 `return true`（只有第一个 `if` 返回 `true`，其余都返回 `false`），因此最后一个 `return true;`
 实际上只在所有相等条件满足时执行。它不需要 `else`，因为前面的 `return` 已经结束了方法，执行到此时自然表示相等。这种写法是标准模式，逻辑正确。


 追问：
 所以用other是为了强转转换为student类型，来访问其私有成员，对吗？那参与比较的对象不都是学生类型吗？还需要强转啊？

 答：
 是的，你理解正确。`other` 就是强转后得到的 `Student` 引用，用于访问 `Student` 类的私有成员。

虽然参与比较的对象在运行时确实是 `Student` 类型，但 `equals` 方法的参数类型是 `Object`，**编译器**只会把它当作 `Object` 类型。为了让编译器允许访问 `Student` 特有的字段（如 `cn`、`sum`），必须进行强制类型转换。如果不转，直接写 `obj.cn` 会编译报错。这就是为什么需要 `Student other = (Student) obj;` 这步转换。
*/

/*
总结：
1. 关于 hashCode() 和 compareTo 的关系
hashCode() 计算出的整数就是哈希值，没错。是为了保证如果两个对象的 equals 返回 true，那么它们的 hashCode 必须相等。的约定

但是 hashCode() 不会调用 compareTo，也不会用来直接判断相等。compareTo 是排序时用的，属于 Comparable 接口，和哈希值无关。

哈希值只是给哈希集合（如 HashSet）做“分组”用的，不是用来比较相等性的。

2. 如何正确重写 equals 和 hashCode？通俗解释
规则很简单：

equals 方法里，你要决定：哪些字段相同，我就认为两个对象相等。比如你认为学号相同就是同一个人，那就比较学号；或者姓名+生日相同，就比较这两个字段。

hashCode 方法里，你必须用和 equals 完全相同的字段去计算一个数字。
为什么要这样？因为如果两个对象 equals 返回 true（比如学号相同），那么它们的 hashCode 必须相同，否则 HashSet 会出问题（相同的对象可能放在不同的桶里，导致无法去重）。
反过来，如果两个对象的 hashCode 相同，equals 不一定为 true（只是有可能相等，但还要进一步比较）。

怎么计算哈希码？
把参与 equals 的字段，用一个公式（比如 result = 31 * result + field.hashCode()）组合起来，得到一个整数。这就是常见的写法。


3.哈希值 = hashCode() 返回的整数。

equals 方法用来判断两个对象内容是否相等（你可以自定义规则）。

hashCode 和 equals 需要保持一致：如果 equals 为 true，则 hashCode 必须相等。



4.不要用哈希值作为 equals 的判断依据，哈希值只用于快速分组。

重写 equals 时，直接比较对象的关键字段（比如姓名、学号等）。

重写 hashCode 时，用与 equals 相同的字段来计算哈希值。

记住约定：equals 相等 → hashCode 相等；反过来不一定。



*/


/*
问：
2. 为什么需要算术运算（乘法和加法）？prime = 31 是什么？

答：
想象一下，我们要为 Student 对象生成一个哈希码，它应该依赖于对象中参与“相等”判断的字段。你的 equals 比较了 cn（语文分）和 sum（总分），所以 hashCode 也应该只由这两个字段决定（先不管设计是否合理）。
如果我们简单地写成：

java
return cn + sum;
那么很多不同的 (cn, sum) 组合可能得到相同的和，导致哈希冲突严重。例如 (50, 150) 和 (100, 100) 都会得到200。

为了减少冲突，常用的技巧是用一个质数（如31）乘以当前结果，再加上新字段的值。这样可以让不同字段的贡献分散到高位和低位，使哈希值分布更均匀。这就是为什么有乘法运算。

prime = 31：选择一个质数，是因为质数乘法可以减少哈希冲突的概率（数学上有依据）。31 是经典的质数，因为它不大不小，而且 JVM 可能对乘以 31 做了优化（31 * i == (i << 5) - i）。

result = 1：初始值，通常设为非零，避免所有字段为0时哈希值为0（虽然不强制）。

然后依次计算：

result = prime * result + cn;

result = prime * result + sum;

这样，即使 cn 和 sum 交换顺序，哈希值也会不同（因为乘法顺序有区分度）。


*/