package ec.edu.uce.ProyectoRelacionDDBB.Repository;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Department;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department getById(long id);
}
