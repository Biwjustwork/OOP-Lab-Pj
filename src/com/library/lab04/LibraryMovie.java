package com.library.lab04;

import java.time.LocalDate;

public class LibraryMovie implements DigitalContent, Taxable{
    private String title;
    private String director;
    private String streamURL;
    private double fileSize;
    private int releaseYear;
    private String genres;
    private double price;
    private String borrow;
    private LocalDate returnDueDate;
    private Member borrowedBy;
    private final String id;


    public LibraryMovie(String title, String director, String streamURL, double fileSize, int releaseYear, String genres, double price) {
        this.title = title;
        this.director = director;
        this.streamURL = streamURL;
        this.fileSize = fileSize;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.price = price;
        this.borrow = "Available";
        this.id = String.valueOf(Math.random()*100);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStreamURL() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBorrow() {
        return borrow;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public String getId() {
        return id;
    }

    public void displayDetails(){
        System.out.println("- Title: "+ title);
        System.out.println("- Director: "+ director);
        System.out.println("- Release Year: "+ releaseYear);
        System.out.println("- Genres: "+ genres);
        System.out.println("- Price: "+ price);
        System.out.println("- Download URL: "+streamURL);
        System.out.println("- File Size: "+ fileSize);
        System.out.println("- Status: "+ borrow);
        if (getBorrow().equals("Available")){
            System.out.println("- Return Due Date: N/A (Book is available)");
        } else {
            System.out.println("- Return Due Date: "+returnDueDate);
        }

    }

    @Override
    public void streamOnline() {
        System.out.println(" Streaming '"+this.title+"' from URL: "+this.streamURL);
        System.out.println("    Starting online stream... connected!");
        System.out.println("    You can now watch the movie without downloading.");
    }

    @Override
    public void download() {
        System.out.println(" Downloading '"+this.title+"' from URL: "+this.streamURL);
        System.out.println("    Downloading file... ("+this.fileSize+" MB)");
        System.out.println("    Download complete! File saved to your device.");
        System.out.println("    You can now watch the movie offline.");
    }

    @Override
    public double calculateTax() {
        double taxRate = 0.05;
        return price * 0.05;
    }
}
