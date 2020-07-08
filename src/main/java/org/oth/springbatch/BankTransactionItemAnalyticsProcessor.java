package org.oth.springbatch;

import org.oth.springbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//@Component
//processor avec etat car il utilise des attributs (totalDebit, totalCredit sont garder en memoire) et il garde le resultat
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction>{

    private double totalDebit;
    private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D"))
            totalDebit+=bankTransaction.getAmount();
        else if (bankTransaction.getTransactionType().equals("C"))
            totalCredit+=bankTransaction.getAmount();
        return bankTransaction;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public double getTotalCredit() {
        return totalCredit;
    }
}
