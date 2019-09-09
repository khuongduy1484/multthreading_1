package demo;


import java.util.Date;

public class Person extends Thread {
  private Book book;
  private BookStore bookStore;
  private int id;

  public Person(int id) {
    this.bookStore = BookStore.getBookStore();
    this.id = id;
  }

  public void borrowBook() {
    try {
      book = bookStore.borrowBook();
      if (book != null) {
        Date date = new Date();
        System.out.println( date.toString()+ " Person " + id + " borrows book " + book.getId() + " successfully");
        System.out.println();
      }
      Thread.sleep(10000);
      bookStore.returnBook(book, id);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    super.run();
    borrowBook();
  }
}
