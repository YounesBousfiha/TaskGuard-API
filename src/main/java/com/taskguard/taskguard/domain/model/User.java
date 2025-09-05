package com.taskguard.taskguard.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String fullName;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8, max = 50)
    private String password;

    @Column(nullable = false)
    @NotBlank
    private LocalDate createdAt;

    @Column(nullable = false)
    @NotBlank
    private LocalDate updatedAt;

}
