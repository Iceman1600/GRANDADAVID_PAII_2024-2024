package ec.edu.uce.ProyectoRelacionDDBB.Repository;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpouseRepository extends JpaRepository<Spouse, Long> {
    Spouse getById(long id);
}