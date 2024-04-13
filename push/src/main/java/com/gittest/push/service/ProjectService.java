package com.journey.emsrelationship.service;

import com.journey.emsrelationship.entity.Project;
import com.journey.emsrelationship.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setName(project.getName());
            existingProject.setEmployeeId(project.getEmployeeId());
            return projectRepository.save(existingProject);
        }
        return null;
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
