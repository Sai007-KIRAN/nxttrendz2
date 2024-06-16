package com.example.nxttrendz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.nxttrendz2.model.Product;

// Write your code here

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

}