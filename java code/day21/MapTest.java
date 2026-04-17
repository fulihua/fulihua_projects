package day21;

import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args)
    {
        /*
        练习：
         "werertrtyuifgkiryuiop"，获取字符串中每一个字母出现的次数。
         要求返回结果格式为 a(1)b(2)d(4)......;
         思路：
         1.获取到字符串中的每一个字母。
         2.用字母取查表，如果查到了该字母对应的次数，就将这个次数+1后重新存回表中。
         如果没有查到呢？将该字母和1存到表中。
         3.每一个字母都查完表后，表中记录的就是所有字母出现的次数。

         字母和次数之间存在对应关系，而且字母是唯一性的，所以可以使用map集合做表进行查询。
         通过结果发现 字母有顺序的，所以可以通过map集合中的treemap作为表。
        */
       String str = "awaa+acr=ebarct,btydui[efgkiryuiop";
       str = getCharCount(str);
       System.out.println(str);
    }

    /*
    获取字符串中的字母出现的次数。
    返回一个每一个字母对应次数的字符串 格式  char1(count)char2(count).....;
    */
   public static String getCharCount(String str){
    //1.将字符串转成字符数组。
    char[] chs = str.toCharArray();

    //2.定义表。treemap.
    TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();

    //3.遍历字符数组。
    for(int i = 0;i<chs.length;i++)
    {
        //判断必须是字母
        if(!(chs[i]>='a'&&chs[i]<='z'||chs[i]>='A'&&chs[i]<='Z')){
            continue;
        }
        //4.将遍历到的字母作为键去查map这个表。获取对应的次数。
        Integer value = map.get(chs[i]);

        //5.有可能要查询的字母在表中不存在对应的次数，需要判断。
        // 如果返回是null，说明字母没有对应的次数。就将这个字母和1存储到表中。
        if(value == null)
        {
            //将字母和1存储。
            map.put(chs[i],1);
        }
        else{
            //否则，说明有对应的次数对次数自增。将字母和新的次数存储到表中。
            value++;
            map.put(chs[i],value);
        }
        /*
        //两个If判断，选择哪个都行。
        int count= 0;
        if(value!=null){
            count = value;//用count记录次数。
        }
        count++;
        map.put(chs[i],count);
        */
    }

    //将map集合或者的键值转成  格式是  a(1)b(2)d(4)......

    return mapToString(map);
   }

   /*
   将map集合中的键值转成 格式是  a(1)b(2)d(4)......
   map中有很多数据，无论是多少个，什么类型，最终都变成字符串。
   StringBuffer 这个容器就符合这个需求。如果单线程，建议使用stringbuilder。
   */
  private static String mapToString(Map<Character,Integer> map){
    //1.明确容器。
    StringBuilder sb = new StringBuilder();

    //2.遍历map集合。
    for(Character key:map.keySet()){
        Integer value = map.get(key);

        sb.append(key+"("+value+")");
    }
    return sb.toString();
  }
}


/*
1.问：为啥要将字符串传成数组？还有continue;这个的作用是啥？以及stringbuilder和stringbuffer的区别和作用都是啥？

答：1. 为什么将字符串转成字符数组？
原代码中：
char[] chs = str.toCharArray();
原因：为了能够逐个访问字符串中的每一个字符。虽然字符串本身可以用 charAt(i) 遍历，但转成字符数组后，代码可以更简洁地使用增强 for 循环（例如 for(char ch : chs)），
或者在循环中通过索引快速访问。这里用的是普通 for 循环，但转成数组并没有本质的必要，只是习惯或为了后续可能的优化。实际上，直接用 str.charAt(i) 也是可以的。

2. continue; 的作用是什么？
在循环中：

java
if(!(chs[i]>='a' && chs[i]<='z' || chs[i]>='A' && chs[i]<='Z')){
    continue;
}
当字符不是字母（即既不是 a-z 也不是 A-Z）时，执行 continue;。

continue 会跳过本次循环的剩余部分（即不统计该字符），直接进入下一次循环。

这样做的目的是只统计字母，忽略其他字符（如数字、标点、空格等），因为这些字符不应被计入字母出现次数。

3. StringBuilder 和 StringBuffer 的区别和作用？
两者都是用于创建可变字符串的类，主要区别在于线程安全性：

类	                线程安全	               性能	    适用场景
StringBuffer	是（方法用 synchronized 修饰）	稍低	多线程环境
StringBuilder	否	更高	单线程环境（绝大多数情况）
作用：在循环中动态拼接字符串时，使用它们可以避免频繁创建不可变的 String 对象，从而提升效率。

可以把 StringBuilder 和 StringBuffer 看作一个可以容纳字符的“可变容器”。你可以往里面添加、插入、删除或修改字符，最后通过 toString() 方法得到一个 String 对象。
与 String 这个“不可变容器”不同，StringBuilder 和 StringBuffer 适合在需要频繁修改字符串内容时使用，避免创建大量临时对象，提高性能。

*/


/*
2.问：那代码中的map中有很多数据，无论是多少个，什么类型，最终都变成字符串。
	 * StringBuffer 这个容器就符合这个需求。如果是单线程，建议使用StringBuilder。
	 * 这句话是什么意思？
     * 
答：这句话的意思是：Map 中存储了若干键值对（例如 Character 和 Integer 类型），我们需要将这些键值对转换成一个字符串，格式如 a(1)b(2)...。
由于键和值可能是不同类型的数据（但最终都要转成字符串形式），我们需要一个能够动态拼接字符串的容器。

StringBuffer 或 StringBuilder 就是这样的容器：它们可以不断追加各种类型的数据（通过 append 方法自动调用 toString() 转换成字符串），最后调用 toString() 得到最终的结果字符串。
因为这里只是单线程执行（没有多线程竞争），所以使用效率更高的 StringBuilder 更合适（StringBuffer 是线程安全的，但性能稍差）。因此注释说“StringBuffer 这个容器就符合这个需求。
如果是单线程，建议使用 StringBuilder。”
*/


/*
3.问：那我代码中的：字母和次数之间存在对应关系，而且字母是唯一性的，所以可以使用map集合做表进行查询。这句话是什么意思？

答：这句话的意思是：在统计字母出现次数的问题中，每个字母与它出现的次数之间存在一一对应的关系。而且，每个字母本身是唯一的（不会重复出现相同的字母作为键）。
因此，我们可以使用 Map 集合来存储这种对应关系：将字母作为 键（key），将出现的次数作为 值（value）。
由于 Map 的键不允许重复，正好符合字母的唯一性要求；而通过键可以快速查询到对应的次数，所以 Map 就像一个“查询表”，能高效地完成“给定字母，获取其次数”的操作。
这正是代码中使用 TreeMap<Character, Integer> 的原因。
*/

/*
4.问：
	private static String mapToString(Map<Character, Integer> map) {为啥这句话中Map<Character,这里是Character？这是规定吗？还是什么？为啥不写string？

    答：你问的是：为什么 Map<Character, Integer> 中不写 String 作为键的类型？

因为我们要统计的是单个字母出现的次数，而不是字符串。每个字母是一个字符（char），对应的包装类是 Character。
如果用 String 作为键，那么键就会变成字符串（例如 "a"、"b"），虽然也可以工作（因为 String 也是引用类型），但这样语义上不如 Character 精确，并且会浪费空间（String 对象比 Character 对象开销大）。
更重要的是，当遍历字符串中的每个字符时，得到的是 char 类型，自动装箱成 Character，直接作为键很方便；如果要用 String，还需要先将 char 转换为长度为1的字符串，多此一举。所以，这里用 Character 是最合适的选择。


*/