package com.optimus.nnlt.service.impl

import com.optimus.nnlt.model.Category
import com.optimus.nnlt.repository.CategoryRepository
import com.optimus.nnlt.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }//findAll

    void updateCategory(Category category){
        categoryRepository.save(category);
    }//add or update (tuy vao pri-key)

    void removeCategoryById(int id){
        categoryRepository.deleteById(id);
    }//delete truyen vao pri-key

    Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }//search theo id

}