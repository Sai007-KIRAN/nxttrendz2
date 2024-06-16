package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.repository.CategoryRepository;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
// Write your code here

@Service
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository cjr;

    @Override
    public ArrayList<Category> allCategory() {
        List<Category> all = cjr.findAll();
        ArrayList<Category> categories = new ArrayList<>(all);
        return categories;
    }

    @Override
    public Category eachCategory(int id) {
        try {
            Category each = cjr.findById(id).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category addCategory(Category category) {
        cjr.save(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        try {
            Category update = cjr.findById(id).get();
            if (category.getName() != null) {
                update.setName(category.getName());
            }
            if (category.getDescription() != null) {
                update.setDescription(category.getDescription());
            }
            cjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCategory(int id) {
        try {
            cjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}