package com.system.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.system.company.model.Project;
import com.system.company.service.ProjectService;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(service.getProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id) {
        Project project = service.getProject(id);
        return project != null ? 
            new ResponseEntity<>(project, HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project newProject = service.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable int id,
            @RequestBody Project project) {
        Project updatedProject = service.updateProject(id, project);
        return updatedProject != null ?
            new ResponseEntity<>(updatedProject, HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
        if(service.getProject(id) == null) {
            return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);
        }
        service.deleteProject(id);
        return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
    }
}