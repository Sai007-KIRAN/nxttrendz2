package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.ProductRepository;
import com.example.nxttrendz2.repository.ProductJpaRepository;
// Write your code here

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository pjr;

    @Autowired
    private CategoryJpaRepository cjr;

    @Override
    public ArrayList<Product> allProduct() {
        List<Product> all = pjr.findAll();
        ArrayList<Product> allproduct = new ArrayList<>(all);
        return allproduct;
    }

    @Override
    public Product eachProduct(int id) {
        try {
            Product product = pjr.findById(id).get();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        Category add = product.getCategory();
        int pId = add.getId();
        try {
            Category complete = cjr.findById(pId).get();
            product.setCategory(complete);
            pjr.save(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(int id, Product product) {
        try {
            Product update = pjr.findById(id).get();
            if (product.getName() != null) {
                update.setName(product.getName());
            }
            if (product.getDescription() != null) {
                update.setDescription(product.getDescription());
            }
            if (product.getPrice() >= 0.0) {
                update.setPrice(product.getPrice());
            }
            if (product.getCategory() != null) {
                Category add = product.getCategory();
                int pId = add.getId();
                Category complete = cjr.findById(pId).get();
                product.setCategory(complete);
            }
            pjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            pjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Category getCategory(int id) {
        try {
            Product view = pjr.findById(id).get();
            return view.getCategory();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}