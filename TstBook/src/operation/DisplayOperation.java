package operation;

import book.Book;
import book.BookList;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-10-29 11:14
 **/
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        for (int i = 0; i < bookList.getUsedSize(); i++){
            Book book = bookList.getBook(i);
            System.out.println(book);
        }

    }
}
