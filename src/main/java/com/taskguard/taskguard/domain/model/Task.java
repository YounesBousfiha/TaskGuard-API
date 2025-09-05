package com.taskguard.taskguard.domain.model;


import com.taskguard.taskguard.domain.model.enums.Priority;
import com.taskguard.taskguard.domain.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, name = "title")
    @NotBlank
    @Size(min = 3, max = 50)
    private String title;

    @Column(nullable = false, name = "description")
    @NotBlank
    @Size(min = 3, max = 50)
    private String Description;

    @Column(nullable = false, name = "priority")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(nullable = false, name = "status")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, name = "duedate")
    @NotBlank
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, name = "createdat")
    @NotBlank
    private LocalDate createdAt;

    @Column(nullable = false, name = "updatedat")
    @NotBlank
    private LocalDate updatedAt;

}
