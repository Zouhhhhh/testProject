public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < this.bookShelf.getLength();
    }

    @Override
    public Object next() {
        Object next = bookShelf.getBookAt(this.index);
        this.index++;
        return next;
    }
}
