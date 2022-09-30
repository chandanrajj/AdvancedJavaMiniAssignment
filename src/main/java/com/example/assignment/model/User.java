package com.example.assignment.model;

import com.example.assignment.util.DateOfBirthValidator;
import com.example.assignment.util.SalaryValidator;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @SalaryValidator
    private Long salary;

    private String name;

    private String email;

    @Temporal(TemporalType.DATE)
    @DateOfBirthValidator
    private Date dateOfBirth;

    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
