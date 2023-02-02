package com.example.sicelo.persistence.model;
import com.example.sicelo.domain.Utilities;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.stream.Collectors;


@Entity
@Table(name = "booking")
public class Booking {


    @Column private long amount;
    @Id
    @GeneratedValue()
    private long id;
    @Column
    private LocalDate bookInDate;
    @Column private LocalDate checkOutDate;

    public Booking(LocalDate bookInDate, LocalDate checkOutDate) {
        setAmount();
        this.bookInDate = bookInDate;
        this.checkOutDate = checkOutDate;
    }

    public Booking(LocalDate bookInDate, LocalDate checkOutDate, long newAmount ) {
        this.amount = newAmount;
        this.bookInDate = bookInDate;
        this.checkOutDate = checkOutDate;
    }

    public Booking() {

    }

    public long getAmount() {
        return amount;
    }

    public void setAmount() {
        this.amount = ( Utilities.DAY_OF_YEAR + 100)/12;
    }

    public LocalDate getBookInDate() {
        return bookInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setBookInDate(LocalDate bookInDate) {
        this.bookInDate = bookInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public long cancelBooking(){
        return penalty();
    }

    public Booking reschedule(LocalDate newDate){
        return new Booking(LocalDate.now(),newDate);
    }

    public Booking reschedule(LocalDate newDate, long newAmount){
        return new Booking(LocalDate.now(), newDate, newAmount);
    }

    public long penalty(){
        if(numberOfDaysUntilCheckout() >= 14){
            return this.amount * Utilities.FULL_REFUND;
        } else if (numberOfDaysUntilCheckout() >= 7 )  {
            return this.amount * Utilities.HALF_REFUND;
        }else{
            return Utilities.NO_REFUND;
        }
    }

    private int numberOfDaysUntilCheckout(){
        return Utilities.TODAY.datesUntil(checkOutDate)
                .collect(Collectors.toList())
                .size();
    }

}