package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionFromGraph.TransactionFromOrg;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionToGraph.TransactionToOrg;

public interface AnalysisService {
    public BudgetToCountry plotBudgetToCountryGraph(int sectorCode);
    public TransactionToOrg plotTransactionToOrgGraph(int sectorCode);
    public TransactionFromOrg plotTransactionFromOrgGraph(int sectorCode);
}
