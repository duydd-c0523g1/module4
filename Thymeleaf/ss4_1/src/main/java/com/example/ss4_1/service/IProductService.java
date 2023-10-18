package com.example.ss4_1.service;

import com.example.ss4_1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product displayProductDetails(int id);
    List<Product> findProductByName(String name);
    Product findProductById(int id);
}
