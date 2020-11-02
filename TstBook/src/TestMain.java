import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-10-29 10:54
 **/
public class TestMain {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：1--》管理员， 2 --》普通用户");
        int choice = scanner.nextInt();


        if (choice == 1){
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        //准备书籍
        BookList bookList = new BookList();
        //2、登录
        User user = login();
        while (true){
            int choice = user.menu();
            //选择是几  就可以对应哪个方法了
            user.doOperation(bookList, choice);
        }
    }
}
