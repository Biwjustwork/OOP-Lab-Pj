package com.library.lab05;

public class PhysicalBook extends LibraryItem implements Taxable {
    private String shelfLocation;
    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails(){
        System.out.println("\uD83D\uDCD6 PHYSICAL BOOK");
        super.displayDetails();
        System.out.println("- Shelf Location: "+this.shelfLocation);
        System.out.println();
    }

    @Override
    public void printSummary(){
        System.out.println("PhysicalBook [Title='"+title+"' , Status='"+borrow+"']" );
    }

    @Override
    public double calculateLateFee(int late){
        return late * 5;
    }

    @Override
    public double calculateTax() {
        double taxBase = 0.07;
        return this.getPrice() * taxBase;
    }
}
