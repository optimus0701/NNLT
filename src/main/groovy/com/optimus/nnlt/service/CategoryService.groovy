package com.optimus.nnlt.service

import com.optimus.nnlt.model.Category
import org.springframework.stereotype.Service

@Service
public interface CategoryService {

    public List<Category> getAllCategory();

    public void updateCategory(Category category);

    public void removeCategoryById(int id);

    public Optional<Category> getCategoryById(int id);

}
