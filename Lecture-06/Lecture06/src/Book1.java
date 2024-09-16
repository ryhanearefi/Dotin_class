public class Book1 {

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String pages;

    public Book1(String title, String author, String publisher, String isbn, String pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;

    }

    private boolean equalsBook(Book1 book) {
        return this.title.equals(book.title);

    }

    public void printTitleEquality(Book1 book) {
        if (this.equalsBook(book)) {
            System.out.println("Title equality");
        } else {
            System.out.println("Title NOT equality");
        }

    }

    public void displayinfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);

    }

}



