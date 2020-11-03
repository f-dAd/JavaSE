/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-11-03 11:22
 **/
//class MyException extends Exception编译时异常
    //class MyException extends RuntimeException 运行时异常
class MyException extends RuntimeException{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
public class ExceptionTest2 {
    public static void func(int x) throws MyException{
        if (x == 10){
            throw new MyException("x == 10");
        }
    }
    public static void main(String[] args) {
        try {
            func(10);
        }catch (MyException e){
            e.printStackTrace();
        }

    }
}
