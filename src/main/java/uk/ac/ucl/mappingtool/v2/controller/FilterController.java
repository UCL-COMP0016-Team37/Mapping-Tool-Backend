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
import uk.ac.ucl.mappingtool.v2.domain.result.response.Response;
import uk.ac.ucl.mappingtool.v2.service.FilterService;

@RestController
@Api(value = "Filter Controller", tags = {"Filter Controller"})
@RequestMapping(value = PropertyConst.root + "/filter")
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/{query}/{page}")
    @ApiOperation(value = "Get the result by specific query and indicated page",
            notes = "It will returns 10 items per page and use IATI cloud standard: https://iatidatastore.iatistandard.org/querybuilder/core-filters ")
    public Response getFilterResult(
            @ApiParam(
                    name = "query",
                    type = "String",
                    value = "Query String follows the iati cloud standard",
                    example = "sector_code:(140) AND recipient_country_code:(AF)",
                    required = true
            )
            @PathVariable("query") String query,
            @ApiParam(
                    name = "page",
                    value = "The page of the response(start from 0)",
                    example = "1",
                    required = true
            )
            @PathVariable("page") int page){
        return filterService.getFilterResult(query, page);
    }
}
