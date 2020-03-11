package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getTransactionsById(String iatiId);
}
