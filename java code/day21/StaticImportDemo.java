package day21;


import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.*;//静态导入，导入是指定的类中的静态成员。
import static java.lang.System.*;

public class StaticImportDemo {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();

        max(list);
        min(list);

        out.println("hello itcast");
    }
}
