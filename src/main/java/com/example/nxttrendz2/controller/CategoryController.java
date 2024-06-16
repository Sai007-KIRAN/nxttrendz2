package com.example.nxttrendz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.service.CategoryJpaService;
// Write your code here

@RestController
public class CategoryController {
    @Autowired
    private CategoryJpaService cjs;

    @GetMapping("/categories")
    public ArrayList<Category> allCategory() {
        return cjs.allCategory();
    }

    @GetMapping("/categories/{categoryId}")
    public Category eachCategory(@PathVariable("categoryId") int id) {
        return cjs.eachCategory(id);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return cjs.addCategory(category);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") int id, @RequestBody Category category) {
        return cjs.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int id) {
        cjs.deleteCategory(id);
    }
}