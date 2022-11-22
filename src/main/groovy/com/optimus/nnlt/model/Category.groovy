package com.optimus.nnlt.model

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int id;

    String name;
}
