import java.lang.reflect.Field;
import java.util.Arrays;
import java.lang.reflect.Field;
/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-11-02 16:30
 **/
public class StringTest {
    public static void main(String[] args) {
        char[] val = {'a', 'b', 'c', 'd'};
        String str = new String(val, 1, 3);
        System.out.println(str);
        String str2 = "hello";
        char ch = str2.charAt(1);
        System.out.println(ch);
    }
    public static void main6(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //利用反射 -- 》 自省的过程  反射
        String str = "hello";
        Class  c1 = String.class;
        Field field = c1.getDeclaredField("value");
        field.setAccessible(true);
        char[] val = (char[])field.get(str);
        val[0] = 'g';
        System.out.println(str);

    }
    public static void main5(String[] args) {
        String str1 = "hello";
        System.out.println(str1.equals("hello"));
        System.out.println("hello".equals(str1));
    }
    public static void func(String str, char[] array){
        str = "aaaaaaa";
        array[0] = 'g';
    }
    public static void main4(String[] args) {
        String str1 = "hello";
        char val[] = {'a'};

        System.out.println(str1);
        System.out.println(Arrays.toString(val));
        func(str1, val);
        System.out.println(str1);
        System.out.println(Arrays.toString(val));
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = str1;

        System.out.println(str1);
        System.out.println(str2);
        str2 = "abc";
        System.out.println(str1);
        System.out.println(str2);
    }
    

    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + "lo";
        String str3 = new String("hel") + "lo";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
    public static void main1(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = "hello";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
