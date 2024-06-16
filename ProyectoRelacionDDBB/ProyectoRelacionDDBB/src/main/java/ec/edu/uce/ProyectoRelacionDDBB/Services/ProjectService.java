package ec.edu.uce.ProyectoRelacionDDBB.Services;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Project;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public void save(Project project) {
        repository.save(project);
    }

    public List<Project> readAll() {
        return repository.findAll();
    }

    public void getByID(long id) {
        Optional<Project> project = repository.findById(id);
        if (project.isPresent()) {
            System.out.println(project.get().toString());
        } else {
            System.out.println("No user found with ID: " + id);
        }
    }

    public void update(Project updatedProject) {
        Optional<Project> existingProjectOptional = repository.findById(updatedProject.getId());
        if (existingProjectOptional.isPresent()) {
            Project existingProject = existingProjectOptional.get();

            existingProject.setName(updatedProject.getName());
            existingProject.setEmployees(updatedProject.getEmployees());

            repository.save(existingProject);
            System.out.println("User updated successfully");
        } else {
            System.out.println("No user found with ID: " + updatedProject.getId() + " to update");
        }
    }

    public void delete(long id) {
        Optional<Project> existingProjectOptional = repository.findById(id);
        if (existingProjectOptional.isPresent()) {
            repository.deleteById(id);
            System.out.println("User deleted successfully");
        } else {
            System.out.println("No user found with ID: " + id + " to delete");
        }
    }
}