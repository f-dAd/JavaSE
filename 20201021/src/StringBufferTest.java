/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-11-02 22:48
 **/
public class StringBufferTest {

    public static void main(String[] args) {
        //StringBuffer stringBuffer = new StringBuffer();
        String s = "hello";
        s = s + "world";
        System.out.println(s);
        //----------相当于下面的过程------------
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("world");
        String ret = sb.toString();
        System.out.println(ret);



    }



}
