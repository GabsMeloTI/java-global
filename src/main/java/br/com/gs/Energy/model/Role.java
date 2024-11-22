package br.com.gs.Energy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity@Table(name = "roles")
@Getter@Setter
public class Role {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String label;

    private List<String> roles;
}
