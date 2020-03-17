package uk.ac.ucl.mappingtool.v2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;
import uk.ac.ucl.mappingtool.v2.service.AnalysisService;

@RestController
@Api(value = "Analysis Controller", tags = {"Analysis Controller"})
@RequestMapping(value = PropertyConst.root + "/analysis")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/{sector}")
    @ApiOperation(value = "Produce the top 4 recipient countries in the sector and rest of it with their percentage",
            notes = "It will return top 4 countries and rest of it unless it is less than 5 countries in the sector search")
    public BudgetToCountry getBudgetToCountryGraph(
            @PathVariable("sector") int sectorCode){
        return analysisService.plotBudgetToCountryGraph(sectorCode);
    }
}
