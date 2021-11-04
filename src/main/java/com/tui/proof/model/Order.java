package com.tui.proof.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table
@Entity(name = "ORDER")
@Data
public class Order implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMBER_PILOTES")
    private int numberPilotes;
    @OneToOne
    @JoinColumn(name = "DELIVERY_ADDRESS")
    private Address deliveryAddress;
    @Column(name = "ORDER_TIME")
    private Date orderTime;
    @OneToOne
    @JoinColumn(name = "USER_OWN")
    private Client userOwn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberPilotes() {
        return numberPilotes;
    }

    public void setNumberPilotes(int numberPilotes) {
        this.numberPilotes = numberPilotes;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Client getUserOwn() {
        return userOwn;
    }

    public void setUserOwn(Client userOwn) {
        this.userOwn = userOwn;
    }
}
