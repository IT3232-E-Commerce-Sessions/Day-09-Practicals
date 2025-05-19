package com.system.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.system.company.model.Project;
import com.system.company.repo.ProjectRepo;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo repo;

    public List<Project> getProjects() {
        return repo.findAll();
    }

    public Project getProject(int id) {
        return repo.findById(id).orElse(null);
    }

    public Project addProject(Project project) {
        return repo.save(project);
    }

    public Project updateProject(int id, Project project) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setName(project.getName());
                    existing.setTotalCost(project.getTotalCost());
                    existing.setEmployees(project.getEmployees());
                    return repo.save(existing);
                })
                .orElse(null);
    }

    public void deleteProject(int id) {
        repo.deleteById(id);
    }
}