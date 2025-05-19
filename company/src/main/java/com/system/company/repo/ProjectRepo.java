package com.system.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.company.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}