package com.tui.proof.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@NamedQueries({
        @NamedQuery(name = "Client.findByLastName", query = "SELECT o FROM ORDER o INNER JOIN CLIENT c ON o.userOwn=c.telephone WHERE c.lastName LIKE :lastName"),
        @NamedQuery(name = "Client.findByFirstName", query = "SELECT o FROM ORDER o INNER JOIN CLIENT c ON o.userOwn=c.telephone WHERE c.firstName LIKE:firstName"),
        @NamedQuery(name = "Client.findByTelephone", query = "SELECT o FROM ORDER o INNER JOIN CLIENT c ON o.userOwn=c.telephone WHERE c.telephone LIKE:telephone")
})    //User can use % or _ to have partial searchs
@Table
@Entity(name = "CLIENT")
@Data
public class Client implements Serializable {
    @Size(min = 2, max = 12)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Size(min = 2, max = 20)
    @Column(name = "LASTNAME")
    private String lastName;
    @Id
    @Size(min = 8, max = 10)
    @Column(name = "TELEPHONE")
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
}
