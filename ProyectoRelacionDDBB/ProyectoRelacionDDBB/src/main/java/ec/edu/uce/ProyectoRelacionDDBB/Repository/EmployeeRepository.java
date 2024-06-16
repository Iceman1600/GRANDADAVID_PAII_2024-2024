package ec.edu.uce.ProyectoRelacionDDBB.Repository;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(long id);
    public List<Employee> getEmployeesByDepartmentId(Long departmentId);
    public List<Employee> getEmployeesByProjectId(Long projectId);
}
