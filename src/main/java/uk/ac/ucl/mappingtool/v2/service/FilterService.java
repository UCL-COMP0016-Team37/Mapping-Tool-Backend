package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.result.response.Response;

public interface FilterService {
    public Response getFilterResult(String query, Integer page);
}
