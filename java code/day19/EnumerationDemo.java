package day19;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
public class EnumerationDemo {
    public static void main(String[] args)
    {
        Vector v = new Vector<>();

        v.addElement("haha1");
        v.addElement("haha2");
        v.addElement("haha3");
        v.addElement("haha4");

        //但是因为名称太长，逐渐衰败
        for(Enumeration en = v.elements();en.hasMoreElements();)
        {
            System.out.println("enumeration:"+en.nextElement());
        }
        for(Iterator it = v.iterator();it.hasNext();)
        {
            System.out.println("iterator:"+it.next());
        }
        for(Object obj:v)
        {
            System.out.println(obj);
        }
    }
}
