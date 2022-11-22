package com.optimus.nnlt.service.impl

import com.optimus.nnlt.model.Product
import com.optimus.nnlt.repository.ProductRepository
import com.optimus.nnlt.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    List<Product> getAllProduct() {
        return productRepository.findAll();
    }//findAll

    @Override
    void updateProduct(Product product) {
        productRepository.save(product);
    }//add or update (tuy vao pri-key)

    @Override
    void removeProductById(long id) {
        productRepository.deleteById(id);
    }//delete dua vao pri-key

    @Override
    Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }//search theo id

    @Override
    List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
    //findList theo ProductDTO.categoryId

}
