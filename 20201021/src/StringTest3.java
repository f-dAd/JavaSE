import java.util.Scanner;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-11-02 21:48
 **/
public class StringTest3 {
    public static String func(String str, int n) {
        if (str == null || n <= 0 || n >= str.length()){
            return null;
        }
        str = reverse(str, 0, n-1);
        str = reverse(str, n, str.length()-1);
        str = reverse(str, 0, str.length()-1);
        return str;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(func(str, n));
    }
    public static String reverse(String str, int begin, int end){
        char[] value = str.toCharArray();

        while (begin < end){
            char tmp = value[begin];
            value[begin] = value[end];
            value[end] = tmp;
            begin++;
            end--;
        }

        return String.copyValueOf(value);

    }
    public static void main3(String[] args) {
        String str = "avbjdfns";
        String ret = reverse(str,0, str.length()-1);
        System.out.println(ret);
    }
    public static void main2(String[] args) {

        //都只对字母有效


        String str = "asaDSF哈哈";
        String ret = str.toUpperCase();
        System.out.println(ret);
        ret = str.toLowerCase();
        System.out.println(ret);
        int[] array = {4, 5, 15};
        System.out.println(str.length());
        System.out.println(array.length);
        String string = "";//空串
        String string2 = null;//空对象

    }
    public static String func(String str){
        String ret = "";
        //不能用next遇到空格会结束
        String[] strings = str.split(" ");
        for (String s: strings){
            ret += s;
        }
        return ret;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String ret = func(str);
            System.out.println(ret);
        }
    }
}
