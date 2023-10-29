package com.shopping_cart.service;

import com.shopping_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    void addProduct(Product product);
}
