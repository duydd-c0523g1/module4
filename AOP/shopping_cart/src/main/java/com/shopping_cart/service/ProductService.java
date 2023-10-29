package com.shopping_cart.service;

import com.shopping_cart.model.Product;
import com.shopping_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public void addProduct(Product product) {
        try {
            this.productRepository.save(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
