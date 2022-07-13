import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate{
    private List<Book> books = new ArrayList<>(1);

    public int getLength() {
        return books.size();
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
