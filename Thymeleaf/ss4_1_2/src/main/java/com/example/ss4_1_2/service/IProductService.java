package com.example.ss4_1_2.service;

import com.example.ss4_1_2.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayList();
    List<Product> findProductByName(String name);
    boolean deleteProduct(int id);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    Product findProductById(int id);
}
