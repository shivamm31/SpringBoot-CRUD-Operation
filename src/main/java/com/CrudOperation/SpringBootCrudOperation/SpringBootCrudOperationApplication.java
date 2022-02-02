package com.CrudOperation.SpringBootCrudOperation;

import com.CrudOperation.SpringBootCrudOperation.model.Employee;
import com.CrudOperation.SpringBootCrudOperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Spring boot crud operation application.
 */
@SpringBootApplication
public class SpringBootCrudOperationApplication implements CommandLineRunner {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Morsion");
		employee.setMailId("John@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Rajan");
		employee1.setLastName("Nandan");
		employee1.setMailId("rajan@gmail.com");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setFirstName("Dinesh");
		employee2.setLastName("Maurya");
		employee2.setMailId("dinesh@gmail.com");
		employeeRepository.save(employee2);

	}
}
