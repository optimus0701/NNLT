package com.optimus.nnlt.service

import com.optimus.nnlt.model.Product
import org.springframework.stereotype.Service

@Service
public interface ProductService {

    List<Product> getAllProductByCategoryId(int id);

    Optional<Product> getProductById(long id);

    void removeProductById(long id);

    void updateProduct(Product product);

    List<Product> getAllProduct();

}