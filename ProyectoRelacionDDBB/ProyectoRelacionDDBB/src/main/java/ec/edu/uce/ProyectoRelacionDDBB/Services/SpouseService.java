package ec.edu.uce.ProyectoRelacionDDBB.Services;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Project;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Spouse;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.ProjectRepository;
import ec.edu.uce.ProyectoRelacionDDBB.Repository.SpouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SpouseService {

    @Autowired
    private SpouseRepository repository;

    public void save(Spouse spouse) {
        repository.save(spouse);
    }

    public List<Spouse> readAll() {
        return repository.findAll();
    }

    public void getByID(long id) {
        Optional<Spouse> spouse = repository.findById(id);
        if (spouse.isPresent()) {
            System.out.println(spouse.get().toString());
        } else {
            System.out.println("No user found with ID: " + id);
        }
    }

    public void update(Spouse updatedSpouse) {
        Optional<Spouse> existingSpouseOptional = repository.findById(updatedSpouse.getId());
        if (existingSpouseOptional.isPresent()) {
            Spouse existingSpouse = existingSpouseOptional.get();

            existingSpouse.setName(updatedSpouse.getName());
            existingSpouse.setEmployee(updatedSpouse.getEmployee());

            repository.save(existingSpouse);
            System.out.println("User updated successfully");
        } else {
            System.out.println("No user found with ID: " + updatedSpouse.getId() + " to update");
        }
    }

    public void delete(long id) {
        Optional<Spouse> existingSpouseOptional = repository.findById(id);
        if (existingSpouseOptional.isPresent()) {
            repository.deleteById(id);
            System.out.println("User deleted successfully");
        } else {
            System.out.println("No user found with ID: " + id + " to delete");
        }
    }
}