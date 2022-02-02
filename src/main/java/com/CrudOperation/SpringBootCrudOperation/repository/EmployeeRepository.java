package com.CrudOperation.SpringBootCrudOperation.repository;

import com.CrudOperation.SpringBootCrudOperation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // CRUD all database method
}
