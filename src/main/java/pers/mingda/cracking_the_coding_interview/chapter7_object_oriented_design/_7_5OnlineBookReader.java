package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.HashMap;

public class _7_5OnlineBookReader {}

class OnlineReaderSystem {

  private Library library;
  private UserManager userManager;
  private Display display;

  private Book activeBook;
  private ReaderUser activeUser;

  public OnlineReaderSystem() {
    userManager = new UserManager();
    library = new Library();
    display = new Display();
  }

  public Library getLibrary() {
    return library;
  }

  public UserManager getUserManager() {
    return userManager;
  }

  public Display getDisplay() {
    return display;
  }

  public Book getActiveBook() {
    return activeBook;
  }

  public void setActiveBook(Book book) {
    activeBook = book;
    display.displayBook(book);
  }

  public ReaderUser getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(ReaderUser user) {
    activeUser = user;
    display.displayUser(user);
  }
}

class Library {

  private HashMap<Integer, Book> books;

  public Book addBook(int id, String details) {
    if (books.containsKey(id)) {
      return null;
    }
    Book book = new Book(id, details);
    books.put(id, book);
    return book;
  }

  public boolean remove(Book b) {
    return remove(b.getID());
  }

  public boolean remove(int id) {
    if (!books.containsKey(id)) {
      return false;
    }
    books.remove(id);
    return true;
  }

  public Book find(int id) {
    return books.get(id);
  }
}

class UserManager {

  private HashMap<Integer, ReaderUser> users;

  public ReaderUser addUser(int id, String details, int accountType) {
    if (users.containsKey(id)) {
      return null;
    }
    ReaderUser user = new ReaderUser(id, details, accountType);
    users.put(id, user);
    return user;
  }

  public ReaderUser find(int id) {
    return users.get(id);
  }

  public boolean remove(ReaderUser u) {
    return remove(u.getID());
  }

  public boolean remove(int id) {
    if (!users.containsKey(id)) {
      return false;
    }
    users.remove(id);
    return true;
  }
}

class Display {

  private Book activeBook;
  private ReaderUser activeUser;
  private int pageNumber = 0;

  public void displayUser(ReaderUser user) {
    activeUser = user;
    refreshUsername();
  }

  public void displayBook(Book book) {
    pageNumber = 0;
    activeBook = book;

    refreshTitle();
    refreshDetails();
    refreshPage();
  }

  public void turnPageForward() {
    pageNumber++;
    refreshPage();
  }

  public void turnPageBackward() {
    pageNumber--;
    refreshPage();
  }

  public void refreshUsername() {
    /* updates username display */
  }

  public void refreshTitle() {
    /* updates title display */
  }

  public void refreshDetails() {
    /* update details display */
  }

  public void refreshPage() {
    /* updated page display */
  }
}

class Book {

  private int bookId;
  private String details;

  public Book(int id, String det) {
    bookId = id;
    details = det;
  }

  public int getID() {
    return bookId;
  }

  public void setID(int id) {
    bookId = id;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String d) {
    details = d;
  }
}

class ReaderUser {

  private int userId;
  private String details;
  private int accountType;

  public void renewMembership() {}

  public ReaderUser(int id, String details, int accountType) {
    userId = id;
    this.details = details;
    this.accountType = accountType;
  }

  /* Getters and setters */
  public int getID() {
    return userId;
  }

  public void setID(int id) {
    userId = id;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public int getAccountType() {
    return accountType;
  }

  public void setAccountType(int t) {
    accountType = t;
  }
}
