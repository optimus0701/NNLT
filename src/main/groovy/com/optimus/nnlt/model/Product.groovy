package com.optimus.nnlt.model

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category category

    double price

    double weight

    String description

    String imageName

}
