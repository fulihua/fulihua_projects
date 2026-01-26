package day03;

public class BreakDemo_day03 {
    public static void main(String[] args)
    {
        outer:for(int x=0;x<3;x++)
        {
            inner:for(int y=0;y<4;y++)
            {
                System.out.println("x="+x);
                break outer;
            }
        }
    }
}
