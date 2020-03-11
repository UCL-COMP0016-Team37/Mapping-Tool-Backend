package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;
import uk.ac.ucl.mappingtool.v2.service.TransactionService;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TransactionImpl implements TransactionService {

    @Override
    public List<Transaction> getTransactionsById(String iatiId) {
        // get the first one
        String url = "https://iatidatastore.iatistandard.org/api/activities/"+ iatiId +"/transactions/?format=json";
        String json = HttpRequest.requestJson(url);
        Type transactionType = new TypeToken<ListView<Transaction>>() {}.getType();
        Gson gson = new Gson();
        ListView<Transaction> transactionList = gson.fromJson(json, transactionType);

        List<Transaction> totalTransactions = transactionList.getResults();

        // get all with loop
        int count = transactionList.getCount(); // the count of total
        int totalPages = count / 10 + 1;

        for(int i = 2; i <= totalPages; i++){
            String nextUrl = "https://iatidatastore.iatistandard.org/api/activities/"+ iatiId +"/transactions/?format=json&page=" + i;
            String nextJson = HttpRequest.requestJson(nextUrl);
            ListView<Transaction> nextTransactionList = gson.fromJson(nextJson, transactionType);
            totalTransactions.addAll(nextTransactionList.getResults());
        }

        return totalTransactions;
    }
}
