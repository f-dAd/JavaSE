import java.util.Scanner;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-11-03 09:22
 **/

/**
 * 1、一定要继承一个父类异常
 *
 */

public class EeceptionTest {
    public static int divide(int x, int y) throws ArithmeticException{
        if (y == 0){
            throw new ArithmeticException("y == 0");
        }
        return x/y;
    }
    public static void main(String[] args) {
       try {
           int ret = divide(20, 0);
           System.out.println(ret);
       }catch (ArithmeticException e){
           e.printStackTrace();
       }
        System.out.println("继续执行");

    }
    public static void func2(){
        int[] array = {10, 5 ,3};
        System.out.println(array[100]);
    }
    public static void main1(String[] args) {
        try {
            func2();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println("after try catch");

    }
    public static int func(){
        int[] array = {10, 5 ,3};
        try {
            System.out.println(array[4]);
            return 1;

        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            e.printStackTrace();
            System.out.println("捕获到了数组越界异常");
            return 3;
        }finally {
            return 2;
        }
    }

}
