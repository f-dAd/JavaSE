package operation;

import book.BookList;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-10-29 11:14
 **/
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);


    }
}
