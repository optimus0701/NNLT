package com.optimus.nnlt.model


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    String name;

    @ManyToMany(mappedBy = "roles")
    List<User> users;

}
