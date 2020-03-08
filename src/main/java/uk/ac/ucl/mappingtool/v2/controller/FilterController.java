package uk.ac.ucl.mappingtool.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.result.response.Response;
import uk.ac.ucl.mappingtool.v2.service.FilterService;

@RestController
@RequestMapping(value = PropertyConst.root + "/filter")
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/{query}/{page}")
    public Response getFilterResult(@PathVariable("query") String query, @PathVariable("page") int page){
        return filterService.getFilterResult(query, page);
    }
}
