package com.library.lab05;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowAmount;
    private MembershipStrategy membershipStrategy;

    public Member(String memberID, String memberName, MembershipStrategy membershipStrategy) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.membershipStrategy = membershipStrategy;
        this.borrowAmount = 0;
    }


    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public void setMembershipStrategy(MembershipStrategy membershipStrategy) {
        this.membershipStrategy = membershipStrategy;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(int borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public boolean tryBorrowed(){
        int limit = membershipStrategy.getBorrowLimit();
        if (borrowAmount >= limit){
            return false;
        }
        borrowAmount++;
        return true;
    }

    public boolean canBorrow() {
        return borrowAmount > 0;
    }

    public void decrementQuota() {
        if (borrowAmount > 0) {
            this.borrowAmount--;
        }
    }

    public void displayMemberInfo(){
        System.out.println("\n--- MEMBER INFO ---");
        System.out.println(" ID: "+ memberID);
        System.out.println(" Name: "+memberName);
        System.out.println(" Membership Type: "+ membershipStrategy.getMembershipType());
        if(membershipStrategy.hasUnlimitedBorrowing()){
            System.out.println(" Borrow Limit: Unlimited");
        } else {
            System.out.println(" Borrow Limit: "+ membershipStrategy.getBorrowLimit());
        }
        System.out.println(" Membership Loan Period Days: "+ membershipStrategy.getLoanPeriodDays());
        System.out.println(" Membership Cost: "+ membershipStrategy.getMembershipCost());
    }

    public double calculateLateFee(double baseFee){
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

}
