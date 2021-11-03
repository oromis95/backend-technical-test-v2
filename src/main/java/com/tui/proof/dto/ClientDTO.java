package com.tui.proof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ClientDTO {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("telephone")
    private String telephone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO client = (ClientDTO) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(telephone, client.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, telephone);
    }
}
