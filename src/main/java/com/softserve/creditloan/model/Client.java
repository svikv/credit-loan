package com.softserve.creditloan.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * The Client class represents {@code Client} entity stored in the database
 */

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 7496968901112896693L;

    private int id;

    @Size(min = 2, max = 75)
    private String firstName;

    @Size(min = 2, max = 75)
    private String lastName;

    private String identificationNumber;

    @Size(min = 10, max = 10)
    private String phone;

    @Size(max = 75)
    @Email(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})$")
    private String email;

    private List<CreditLine> creditLines;

    public Client(int id, String firstName, String lastName, String identificationNumber, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.email = email;
    }

    public Client(String firstName, String lastName, String identificationNumber, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.email = email;
    }

    public Client() {
    }

    @OneToMany(mappedBy = "client", targetEntity = CreditLine.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<CreditLine> getCreditLines() {
        return creditLines;
    }

    public void setCreditLines(List<CreditLine> creditLines) {
        this.creditLines = creditLines;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }
}