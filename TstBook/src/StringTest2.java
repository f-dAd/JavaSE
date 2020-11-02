import java.util.Arrays;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-11-02 19:04
 **/
public class StringTest2 {
    public static void main(String[] args) {
        String str1 = "abcdef";
        boolean flg = str1.contains("abc");
        System.out.println(flg);
    }
    public static void main4(String[] args) {
        String str1 = "       abs   dab da bh  ";
        String ret = str1.trim();
        System.out.println(ret);
        //代表从这个位置开始截取，到结束位置
//        String ret = str1.substring(1);
//        System.out.println(ret);
        String ret1 = str1.substring(1,4);//[1, 4)
        System.out.println(ret1);

    }
    public static void main3(String[] args) {
        String str1 = "absdabasdabdabhd";
        String ret = str1.replace('a', 'q');
        System.out.println(ret);
        String ret1 = str1.replace("ab", "qq");
        System.out.println(ret1 );
        String ret2 = str1.replaceAll("ab", "qq");
        System.out.println(ret2);
        String ret3= str1.replaceFirst("ab", "qq");
        System.out.println(ret3);
    }
    public static void main2(String[] args) {
        byte[] bytes = {97, 98, 99, 100};
        String str = new String(bytes);
        System.out.println(str);
        String str2 = "abcde";
        byte[] bytes1 = str2.getBytes();
        System.out.println(Arrays.toString(bytes1));
    }
    public static boolean func(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if ('0' > ch || ch > '9'){
                return false;
            }
        }
        return true;
    }
    public static void main1(String[] args) {
        String str = "123456";
        boolean flg = func(str);
        System.out.println(flg);
    }
}
