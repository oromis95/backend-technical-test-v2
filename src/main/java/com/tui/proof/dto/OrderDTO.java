package com.tui.proof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class OrderDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty
    private Date orderTime;
    @JsonProperty("numberOfPilotes")
    private Integer numberOfPilotes;
    @JsonProperty("orderTotal")
    private Integer orderTotal;
    @JsonProperty("address")
    private AddressDTO address;
    @JsonProperty("client")
    private ClientDTO client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getNumberOfPilotes() {
        return numberOfPilotes;
    }

    public void setNumberOfPilotes(Integer numberOfPilotes) {
        this.numberOfPilotes = numberOfPilotes;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO order = (OrderDTO) o;
        return Objects.equals(id, order.id) && Objects.equals(orderTime, order.orderTime) && Objects.equals(numberOfPilotes, order.numberOfPilotes) && Objects.equals(orderTotal, order.orderTotal) && Objects.equals(address, order.address) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderTime, numberOfPilotes, orderTotal, address, client);
    }
}
