package ec.edu.uce.ProyectoRelacionDDBB.Repository;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project getById(long id);
}