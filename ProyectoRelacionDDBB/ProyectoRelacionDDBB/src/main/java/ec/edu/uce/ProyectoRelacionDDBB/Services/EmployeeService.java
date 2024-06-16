package ec.edu.uce.ProyectoRelacionDDBB.Services;


import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.DepartmentRepository;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DepartmentRepository repository2;
    @Autowired
    private DepartmentRepository repository3;

    public void save(Employee employee) {

        repository.save(employee);
    }

    public List<Employee> readAll() {
        return repository.findAll();
    }
    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return (List<Employee>) repository2.getById(departmentId);
    }

    public List<Employee> getEmployeesByProjectId(Long projectId) {
        return (List<Employee>) repository3.getById(projectId);
    }

    public void getByID(long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee .isPresent()) {
            System.out.println(employee .get().toString());
        } else {
            System.out.println("NNo user found with ID: " + id);
        }
    }


    public void update(Employee updatedEmployee) {
        Optional<Employee> existingUserOptional = repository.findById(updatedEmployee.getId());
        if (existingUserOptional.isPresent()) {
            Employee existingUser = existingUserOptional.get();

            existingUser.setName(updatedEmployee.getName());
            existingUser.setPosition(updatedEmployee.getPosition());
            existingUser.setSpouse(updatedEmployee.getSpouse());
            existingUser.setProject(updatedEmployee.getProject());
            existingUser.setDepartment(updatedEmployee.getDepartment());

            repository.save(existingUser);
            System.out.println("User updated successfully");
        } else {
            System.out.println("No user found with ID: " + updatedEmployee.getId() + "to update");
        }
    }


    public void delete(long id) {
        Optional<Employee> existingUserOptional = repository.findById(id);
        if (existingUserOptional.isPresent()) {
            repository.deleteById(id);
            System.out.println("User deleted successfully");
        } else {
            System.out.println("No user found with ID: " + id + " to delete");
        }
    }
}
