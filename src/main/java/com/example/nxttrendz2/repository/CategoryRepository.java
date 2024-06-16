package com.example.nxttrendz2.repository;

import java.util.ArrayList;
import com.example.nxttrendz2.model.Category;
import org.springframework.stereotype.Repository;

// Write your code here

@Repository
public interface CategoryRepository {
    ArrayList<Category> allCategory();

    Category eachCategory(int id);

    Category addCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}