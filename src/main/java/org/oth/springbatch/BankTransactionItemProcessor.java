package org.oth.springbatch;

import org.oth.springbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//@Component
//processor sans etat stateless il ne garde rien
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, BankTransaction>{

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy-HH:mm");

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
        return bankTransaction;
    }
}
