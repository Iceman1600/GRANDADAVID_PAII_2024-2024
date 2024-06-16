package ec.edu.uce.ProyectoRelacionDDBB;

import ec.edu.uce.ProyectoRelacionDDBB.Models.Department;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Employee;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Project;
import ec.edu.uce.ProyectoRelacionDDBB.Models.Spouse;
import ec.edu.uce.ProyectoRelacionDDBB.Services.DepartmentService;
import ec.edu.uce.ProyectoRelacionDDBB.Services.EmployeeService;
import ec.edu.uce.ProyectoRelacionDDBB.Services.ProjectService;
import ec.edu.uce.ProyectoRelacionDDBB.Services.SpouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoRelacionDdbbApplication implements CommandLineRunner {

	@Autowired
     EmployeeService service1;
	@Autowired
	 DepartmentService service2;
	@Autowired
	 ProjectService service3;
	@Autowired
	 SpouseService service4;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRelacionDdbbApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee();
        Employee employee2 = new Employee();
		Spouse spouse1 = new Spouse();
		Spouse spouse2 = new Spouse();
		Department department1 = new Department();
		Department department2 = new Department();
		Project project1 = new Project();
		Project project2 = new Project();

		employee1.setName("Pepe");
		employee1.setPosition("Director");
		employee1.setDepartment( department1);
		employee1.setSpouse(spouse1);
		service1.save(employee1);

		employee1.setName("Marcos");
		employee1.setPosition("Salesman");
		employee1.setDepartment( department2);
		employee1.setSpouse(spouse2);
		service1.save(employee2);

		spouse1.setName("Maria");
		spouse1.setEmployee(employee1);
		service4.save(spouse1);

		spouse2.setName("Ana");
		spouse1.setEmployee(employee2);
		service4.save(spouse2);

		department1.setName(" Marketing Department");
		service2.save(department1);

		department2.setName("Human Recourses Department");
		service2.save(department2);

		project1.setName("market study of the new product");
		service3.save(project1);

		project2.setName("staff motivation project");
		service3.save(project2);


		service1.readAll();
		service2.readAll();
		service3.readAll();
		service4.readAll();

		employee1.setName("Juan");
		employee1.setPosition("Manager");
		employee1.setDepartment(department2);
		employee1.setSpouse(spouse2);
		service1.update(employee1);

		employee2.setName("Johan");
		employee2.setPosition("Executive");
		employee2.setDepartment( department1);
		employee2.setSpouse(spouse1);
		service1.update(employee1);

		spouse1.setName("Johanna");
		spouse1.setEmployee(employee2);
		service4.update(spouse1);

		spouse2.setName("Diana");
		spouse2.setEmployee(employee1);
		service4.update(spouse2);

		department1.setName("Department of finance");
		service2.update(department1);

		project1.setName("Cost Reduction Project");
		service3.update(project1);
	}
}
