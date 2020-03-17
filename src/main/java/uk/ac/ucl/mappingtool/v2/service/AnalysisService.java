package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;

public interface AnalysisService {
    public BudgetToCountry plotBudgetToCountryGraph(int sectorCode);
}
