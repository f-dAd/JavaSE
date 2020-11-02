package book;

/**
 * @program: TstBook
 * @description
 * @author: YouName
 * @create: 2020-10-29 10:58
 **/
public class BookList {
    private Book[] books = new Book[100];
    private int usedSize = 0;

    public BookList() {
        this.books[0] = new Book("西游记", "吴承恩", 100, "小说");
        this.books[1] = new Book("三国演义", "罗贯中", 100, "小说");
        this.books[2] = new Book("水浒传", "施耐庵", 100, "小说");
        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public void setBooks(int pos, Book book){
        this.books[pos] = book;

    }
    public Book getBook(int pos){
        return books[pos];

    }
}
