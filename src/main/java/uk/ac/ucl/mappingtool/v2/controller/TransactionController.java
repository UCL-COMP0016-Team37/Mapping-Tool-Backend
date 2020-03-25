package uk.ac.ucl.mappingtool.v2.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;
import uk.ac.ucl.mappingtool.v2.service.TransactionService;

import java.util.List;

@RestController
@Api(value = "Transaction Controller", tags = {"Transaction Controller"})
@RequestMapping(value = PropertyConst.root + "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "get the transaction list of one specific activity by its id",
            notes = "It is different from the activity api, this will return the transaction detail of one activity")
    public List<Transaction> getTransactionList(@PathVariable("id") String id){
        return transactionService.getTransactionsById(id);
    }

}
