package com.CrudOperation.SpringBootCrudOperation.controller;

import com.CrudOperation.SpringBootCrudOperation.exception.ResourceNotFoundException;
import com.CrudOperation.SpringBootCrudOperation.model.Employee;
import com.CrudOperation.SpringBootCrudOperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Employee controller.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/" )
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get all employees list.
     *
     * @return the list
     */
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    /**
     * Create employee employee.
     *
     * @param employee the employee
     * @return the employee
     */
// build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return  employeeRepository.save(employee);
    }

    /**
     * Get employee by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
// build get employee RST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee RST API

    /**
     * Update employee response entity.
     *
     * @param id              the id
     * @param employeeDetails the employee details
     * @return the response entity
     */
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " +id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setMailId(employeeDetails.getMailId());

        employeeRepository.save(updateEmployee);

        return  ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API

    /**
     * Delete employee response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
