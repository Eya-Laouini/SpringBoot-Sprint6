package com.ons.users.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY) 
private Long role_id;
private String role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;


    public Role(Object o, String admin) {
        this.role=admin;
        this.role_id= (Long) o;
    }
}