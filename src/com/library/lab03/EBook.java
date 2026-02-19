package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;
    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 0.0, "Available");
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
}
