package com.softserve.creditloan.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The Payment class represents {@code Payment} entity stored in the database
 */

@Entity
@Table(name = "payment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "creditLine")
public class Payment implements Serializable {

    private static final long serialVersionUID = -4609449949072647059L;

    private int id;
    private int monthPeriod;
    private int paymentAmount;
    private CreditLine creditLine;

    public Payment(int monthPeriod, int paymentAmount) {
        this.monthPeriod = monthPeriod;
        this.paymentAmount = paymentAmount;
    }

    public Payment(){
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

    public int getMonthPeriod() {
        return monthPeriod;
    }

    public void setMonthPeriod(int monthPeriod) {
        this.monthPeriod = monthPeriod;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @ManyToOne
    @JoinColumn(name = "creditLineId")
    public CreditLine getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(CreditLine creditLine) {
        this.creditLine = creditLine;
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