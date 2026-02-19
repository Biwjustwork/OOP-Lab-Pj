package com.library.lab03;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowAmount = 3;

    public Member(String memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
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
        if (borrowAmount > 0){
            borrowAmount--;
            return true;
        }
        return false;
    }

    public boolean canBorrow() {
        return borrowAmount > 0;
    }

    public void decrementQuota() {
        if (borrowAmount > 0) {
            this.borrowAmount--;
        }
    }

}
