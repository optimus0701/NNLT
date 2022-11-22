package com.optimus.nnlt.dto

import lombok.Data;


@Data
class ProductDTO {
    Long id;

    String name;

    int categoryId;

    double price;

    double weight;

    String description;

    String imageName;

}
