package com.selfMyBatis.library.dto;

import java.util.Date;

public class RentDto {

    private int rentId;
    private int memberId;
    private int bookId;
    private Date rentDate;
    private Date returnDate;

    public RentDto(int rentId, int memberId, int bookId, Date rentDate, Date returnDate) {
        this.rentId = rentId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
    public RentDto() {
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "RentDto{" +
                "rentId=" + rentId +
                ", memberId=" + memberId +
                ", bookId=" + bookId +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
