package designpattern.structural.flyweight.without;

public class Main {

    private static final int BOOK_TYPES = 2;
    private static final int BOOKS_TO_INSERT = 10_000_000;

    // The implementation is machine dependent
    // If the machine is not able to store upto 10,000,000 records
    // then we will get the Memory Error.
    public static void main(String[] args) {
        BookStore store = new BookStore();
        for(int i = 0; i < BOOKS_TO_INSERT / BOOK_TYPES; i++) {
            store.storeBook("abc", 100.0, "Action", "Follett", "Stuff");
            store.storeBook("xyz", 200.0, "Fantasy", "Ingram", "Extra");
        }
        store.displayBooks();
    }
}
