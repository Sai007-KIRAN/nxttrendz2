package com.example.nxttrendz2.repository;

import java.util.ArrayList;
import com.example.nxttrendz2.model.Product;
import org.springframework.stereotype.Repository;
import com.example.nxttrendz2.model.Category;
// Write your code here

@Repository
public interface ProductRepository {
    ArrayList<Product> allProduct();

    Product eachProduct(int id);

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

    Category getCategory(int id);
}