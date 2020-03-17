package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.analysis.response.FundingToGraph.FundingToCountry;

public interface AnalysisService {
    public FundingToCountry plotFundingToCountryGraph(int sectorCode);
}
