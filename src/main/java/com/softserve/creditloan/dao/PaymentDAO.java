package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;

import java.util.List;

public interface PaymentDAO {
    void savePayment(Payment payment, CreditLine creditLine);
    List<Payment> loadAllPayments(int id);
}
