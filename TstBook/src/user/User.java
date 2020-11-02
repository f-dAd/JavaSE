package user;

import book.BookList;
import operation.IOperation;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-10-29 17:41
 **/
public abstract class User {
    protected String name;

    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void doOperation(BookList bookList, int choice){
        this.operations[choice].work(bookList);
    }
}
