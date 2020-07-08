package org.oth.springbatch.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
@Entity
public class BankTransaction {
    @Id
    private Long id;
    private Long accountId;
    private Date transactionDate;
    @Transient
    private String strTransactionDate;
    private String transactionType;
    private Double amount;

    public BankTransaction() {
    }

    public BankTransaction(Long id, Long accountId, Date transactionDate, String strTransactionDate, String transactionType, Double amount) {
        this.id = id;
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.strTransactionDate = strTransactionDate;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getStrTransactionDate() {
        return strTransactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setStrTransactionDate(String strTransactionDate) {
        this.strTransactionDate = strTransactionDate;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", transactionDate=" + transactionDate +
                ", strTransactionDate='" + strTransactionDate + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
