package com.exo1.exo1.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "projet",
    indexes = @Index(name = "idx_projet_name", columnList = "name")
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projet_id")
    private Long id;

    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_projet", joinColumns = @JoinColumn(name = "projet_id"), inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users;

    @OneToMany(mappedBy = "projet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks;

}
