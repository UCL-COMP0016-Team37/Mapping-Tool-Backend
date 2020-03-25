package uk.ac.ucl.mappingtool.v2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.sectorInGraph.SectorInCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.topOrgGraph.TopFilteredOrgs;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.topOrgGraph.TopOrgs;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionFromGraph.TransactionFromOrg;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionToGraph.TransactionToOrg;
import uk.ac.ucl.mappingtool.v2.service.AnalysisService;

@RestController
@Api(value = "Analysis Controller", tags = {"Analysis Controller"})
@RequestMapping(value = PropertyConst.root + "/analysis")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/budget-to-country/{sector}")
    @ApiOperation(value = "Produce the top 4 recipient countries in the sector and rest of it with their percentage",
            notes = "It will return top 4 countries and rest of it unless it is less than 5 countries in the sector search")
    public BudgetToCountry getBudgetToCountryGraph(
            @PathVariable("sector") int sectorCode){
        return analysisService.plotBudgetToCountryGraph(sectorCode);
    }

    @GetMapping("/transaction-to-org/{sector}")
    @ApiOperation(value = "Produce the top 4 receiving organizations in the sector and rest of it with their percentage",
            notes = "It will return top 4 organizations and rest of it unless it is less than 5 countries in the sector search")
    public TransactionToOrg getTransactionToOrgGraph(
            @PathVariable("sector") int sectorCode){
        return analysisService.plotTransactionToOrgGraph(sectorCode);
    }

    @GetMapping("/transaction-from-org/{sector}")
    @ApiOperation(value = "Produce the top 4 providing Organizations in the sector and rest of it with their percentage",
            notes = "It will return top 4 organizations and rest of it unless it is less than 5 countries in the sector search")
    public TransactionFromOrg getTransactionFromOrgGraph(
            @PathVariable("sector") int sectorCode){
        return analysisService.plotTransactionFromOrgGraph(sectorCode);
    }

    @GetMapping("/topOrgs")
    @ApiOperation(value = "Produce the top 100 report organizations with their percentage",
            notes = "It will only return 100 of them")
    public TopOrgs getTop100(){
        return analysisService.plotTopDefault();
    }

    @GetMapping("/topOrgs/sector={sector}&country={country}")
    @ApiOperation(value = "Produce the top 4 report organizations with their percentage",
            notes = "It will return top 4 organizations and rest of it unless it is less than 5 result in the filter")
    public TopFilteredOrgs getTopOrgs(
            @PathVariable("sector")
                    int sectorCode,
            @PathVariable("country")
                    String countryCode){
        return analysisService.plotTopOrgsFromFilter(sectorCode, countryCode);
    }

    @GetMapping("/topOrgs/country={country}")
    @ApiOperation(value = "Produce the top 4 report organizations with their percentage (Filter Country Only)",
            notes = "It will return top 4 organizations and rest of it unless it is less than 5 result in the filter")
    public TopFilteredOrgs getTopOrgsCountry(@PathVariable("country") String countryCode){
        return analysisService.plotTopOrgsFromFilterCounrty(countryCode);
    }

    @GetMapping("/sector-in-country/{country}")
    @ApiOperation(value = "Produce the top 4 Sector in the country with their percentage",
            notes = "It will return top 4 sectors and rest of it unless it is less than 5 sectors in the country search")
    public SectorInCountry getSectorInCountryGraph(@PathVariable("country") String countryCode){
        return analysisService.plotSectorInCountryGraph(countryCode);
    }



}
