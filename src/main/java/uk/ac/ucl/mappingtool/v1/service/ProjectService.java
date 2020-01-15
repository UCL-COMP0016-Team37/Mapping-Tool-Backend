package uk.ac.ucl.mappingtool.v1.service;

import uk.ac.ucl.mappingtool.v1.domain.Project;

import java.util.Iterator;
import java.util.List;

public interface ProjectService {
    public List<Project> getAllProject();
    public Iterator<Project> getPartProject(int pageNum, int pageSize);
    public Project selectById(String id);
}
