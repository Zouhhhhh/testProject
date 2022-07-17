package test;

import aggregate.Book;
import aggregate.BookShelf;
import iterator.Iterator;


public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("book1"));
        bookShelf.appendBook(new Book("book2"));
        bookShelf.appendBook(new Book("book3"));
        bookShelf.appendBook(new Book("book4"));

        Iterator bookShelfIterator = bookShelf.iterator();
        while (bookShelfIterator.hasNext()) {
            Book book = (Book) bookShelfIterator.next();
            System.out.println(book.getBookName());
        }

        System.out.println("=========遍历拿完了");
        System.out.println("=========又加了两个");
        bookShelf.appendBook(new Book("book_add1"));
        bookShelf.appendBook(new Book("book_add2"));

        while (bookShelfIterator.hasNext()) {
            Book book = (Book) bookShelfIterator.next();
            System.out.println(book.getBookName());
        }
    }
}
