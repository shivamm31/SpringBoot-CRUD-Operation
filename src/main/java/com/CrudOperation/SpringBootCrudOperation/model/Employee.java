package com.CrudOperation.SpringBootCrudOperation.model;

import lombok.*;

import javax.persistence.*;

/**
 * The type Employee.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "employees" )
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private  String mailId;
}
