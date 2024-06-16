package com.example.nxttrendz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.service.ProductJpaService;

// Write your code here

@RestController
public class ProductController {
    @Autowired
    private ProductJpaService pjs;

    @GetMapping("/categories/products")
    public ArrayList<Product> allProduct() {
        return pjs.allProduct();
    }

    @GetMapping("/categories/products/{productId}")
    public Product eachProduct(@PathVariable("productId") int id) {
        return pjs.eachProduct(id);
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return pjs.addProduct(product);
    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int id, @RequestBody Product product) {
        return pjs.updateProduct(id, product);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int id) {
        pjs.deleteProduct(id);
    }

    @GetMapping("/products/{productId}/category")
    public Category getCategory(@PathVariable("productId") int id) {
        return pjs.getCategory(id);
    }
}