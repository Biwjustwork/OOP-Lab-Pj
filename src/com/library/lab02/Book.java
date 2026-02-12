package com.library.lab02;

import java.time.LocalDate;


public class Book {
    protected String bookId;
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected String borrow;
    protected LocalDate returnDueDate;

    public Book (String bookId,String title, String author, String isbn,double price, String borrow ){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.borrow = borrow;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getBorrow() {
        return borrow;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void displayDetails(){
        System.out.println("- BookID: "+ bookId);
        System.out.println("- Title: "+ title);
        System.out.println("- Author: "+ author);
        System.out.println("- ISBN: "+ isbn);
        System.out.println("- Price: "+ price);
        System.out.println("- Status: "+ borrow);
        if (getBorrow().equals("Available")){
            System.out.println("- Return Due Date: N/A (Book is available)");
        } else {
            System.out.println("- Return Due Date: "+returnDueDate);
        }
        System.out.println();
    }

    public void checkOut(Member member){
        if (!borrow.equalsIgnoreCase("Available")) {
            System.out.println("Error: BookID '"+bookId+"' Book '" + title + "' is already borrowed.");
            System.out.println();
            return;
        }
        if (member.tryBorrowed()){
            System.out.println("Book ["+title+"] BookID ["+bookId+"]  has been borrowed by ["+ member.getMemberName()+"]");
            this.returnDueDate = LocalDate.now().plusDays(14);
            this.borrow = "Borrowed";
            System.out.println("Return Due Date: "+ returnDueDate);
        } else {
            System.out.println("Member '"+member.getMemberName()+"' has reached the borrow limit (3).");
            System.out.println("Borrow request denied for member "+member.getMemberName()+".");
        }
    }

    public void returnBook(){
        if (borrow.equalsIgnoreCase("Borrowed")){
            this.borrow = "Available";
            System.out.println("Book '"+title+"' BookID '"+bookId+"'  has been returned successfully.");
        } else {
            System.out.println("Error: Book '"+title+"' BookID '"+bookId+"' is not borrowed yet and cannot be return book again.");
        }
        System.out.println();
    }

    public void printSummary(){
        System.out.println("BookID ["+bookId+"] , Book [Title='"+title+"' , Status='"+borrow+"']" );
    }
}
