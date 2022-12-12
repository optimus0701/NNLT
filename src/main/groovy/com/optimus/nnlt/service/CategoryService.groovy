package com.optimus.nnlt.service

import com.optimus.nnlt.model.Category
import org.springframework.stereotype.Service

@Service
interface CategoryService {

    List<Category> getAllCategory();

    void updateCategory(Category category);

    void removeCategoryById(int id);

    Optional<Category> getCategoryById(int id);

}
