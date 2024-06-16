package ec.edu.uce.ProyectoRelacionDDBB.Services;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Department;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;


    public void save(Department department) {
        repository.save(department);
    }

    public List<Department> readAll() {
        return repository.findAll();
    }

    public void getByID(long id) {
        Optional<Department> department = repository.findById(id);
        if (department.isPresent()) {
            System.out.println(department.get().toString());
        } else {
            System.out.println("No user found with ID: " + id);
        }
    }

    public void update(Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = repository.findById(updatedDepartment.getId());
        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();

            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setEmployees(updatedDepartment.getEmployees());

            repository.save(existingDepartment);
            System.out.println("User updated successfully");
        } else {
            System.out.println("No user found with ID: " + updatedDepartment.getId() + " to update");
        }
    }

    public void delete(long id) {
        Optional<Department> existingDepartmentOptional = repository.findById(id);
        if (existingDepartmentOptional.isPresent()) {
            repository.deleteById(id);
            System.out.println("User deleted successfully");
        } else {
            System.out.println("No user found with ID: " + id + " to delete");
        }
    }
}

