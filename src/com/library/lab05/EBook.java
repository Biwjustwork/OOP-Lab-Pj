package com.library.lab05;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSize;
    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 99.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails(){
        System.out.println("\uD83D\uDCF1 E-BOOK");
        super.displayDetails();
        System.out.println("- Download URL: "+this.downloadUrl);
        System.out.println("- File Size: "+ this.fileSize);
        System.out.println();
    }

    @Override
    public void printSummary(){
        System.out.println("E-Book [Title='"+title+"' , Status='"+borrow+"']" );
    }

    @Override
    public double calculateLateFee(int late) {
        return 0;
    }

    @Override
    public void streamOnline() {
        System.out.println(" Streaming '"+this.title+"' from URL: "+this.downloadUrl);
        System.out.println("    Starting online stream... connected!");
        System.out.println("    You can now read the book online without downloading.");

    }

    @Override
    public void download() {
        System.out.println(" Downloading '"+this.title+"' from URL: "+this.downloadUrl);
        System.out.println("    Downloading file... ("+this.fileSize+" MB)");
        System.out.println("    Download complete! File saved to your device.");
        System.out.println("    You can now read the book offline.");
    }

    @Override
    public double calculateTax() {
        double digitalTax = 0.05;
        return this.getPrice() * digitalTax;
    }
}
