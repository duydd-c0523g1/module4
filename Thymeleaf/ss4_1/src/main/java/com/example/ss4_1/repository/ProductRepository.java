package com.example.ss4_1.repository;

import com.example.ss4_1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1, new Product(1, "Nike Air Force 1'07 EasyOn", 120, "Shoes"));
        productMap.put(2, new Product(2, "Nike Dunk Low", 125, "Men's Shoes"));
        productMap.put(3, new Product(3, "Air Jordan 1 Low SE", 125, "Men's Shoes"));
        productMap.put(4, new Product(4, "Nike Air Max 90", 125, "Men's Shoes"));
        productMap.put(5, new Product(5, "Nike Air Max 90 GORE-TEX", 140, "Men's Shoes"));
        productMap.put(6, new Product(6, "Nike Air Force 1'07", 125, "Men's Shoes"));
        productMap.put(7, new Product(7, "Nike Dunk Low Retro", 110, "Men's Shoes"));
        productMap.put(8, new Product(8, "Nike Air Force 1'07 WB", 125, "Men's Shoes"));
    }
    @Override
    public List<Product> displayProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Product product) {
        List<Product> productList = new ArrayList<>(productMap.values());
        product.setId(productList.get(productList.size() - 1).getId() + 1);
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        List<Product> productList = new ArrayList<>(productMap.values());
        for (Product p : productList) {
            if (product.getId() == p.getId()) {
                productMap.put(product.getId(), product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public Product displayProductDetails(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }
}
