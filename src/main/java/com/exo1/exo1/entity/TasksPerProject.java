package com.exo1.exo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_per_project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksPerProject {
    @Id
    @Column(name = "projet_id")
    private Long projetId;

    @Column(name = "count")
    private Long taskCount;
}
