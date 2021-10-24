package com.tui.proof.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name = "ORDER")
@Data
public class Order implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMBER")
    private String number;
    @OneToOne
    @JoinColumn(name = "DELIVERY_ADDRESS")
    private Address deliveryAddress;
    @Column(name = "PILOTES")
    private int pilotes;
    @Column(name = "ORDERTOTAL")
    private double orderTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getPilotes() {
        return pilotes;
    }

    public void setPilotes(int pilotes) {
        this.pilotes = pilotes;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
