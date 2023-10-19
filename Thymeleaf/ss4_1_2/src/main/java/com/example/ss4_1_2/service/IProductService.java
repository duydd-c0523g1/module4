package com.example.ss4_1_2.service;

import com.example.ss4_1_2.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayList();
    List<Product> findProductByName(String name);
    void deleteProduct(Product product);
    void addProduct(Product product);
    void updateProduct(Product product);
    Product findProductById(int id);
}
