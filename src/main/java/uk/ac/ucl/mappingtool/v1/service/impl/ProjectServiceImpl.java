package uk.ac.ucl.mappingtool.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.v1.domain.Project;
import uk.ac.ucl.mappingtool.v1.repository.ProjectRepository;
import uk.ac.ucl.mappingtool.v1.service.ProjectService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Iterator<Project> getPartProject(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "projectName");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<Project> projects = projectRepository.findAll(pageable);
        Iterator<Project> projectIterator = projects.iterator();

        return projectIterator;
    }

    @Override
    public Project selectById(String id) {
        Optional<Project> optional = projectRepository.findById(id);
        Project project = optional.get();

        return project;
    }

}
