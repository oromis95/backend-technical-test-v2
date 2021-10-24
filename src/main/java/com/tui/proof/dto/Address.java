package com.tui.proof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Address {
    @JsonProperty("street")
    private String street;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("id")
    private Integer id;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(postCode, address.postCode) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postCode, city, country, id);
    }
}
