package com.example.ss4_1_2.repository;

import com.example.ss4_1_2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Nike Air Force 1'07 EasyOn", 120, "Shoes"));
        productList.add(new Product(2, "Nike Dunk Low", 125, "Men's Shoes"));
        productList.add(new Product(3, "Air Jordan 1 Low SE", 125, "Men's Shoes"));
        productList.add(new Product(4, "Nike Air Max 90", 125, "Men's Shoes"));
        productList.add(new Product(5, "Nike Air Max 90 GORE-TEX", 140, "Men's Shoes"));
        productList.add(new Product(6, "Nike Air Force 1'07", 125, "Men's Shoes"));
    }
    @Override
    public List<Product> displayList() {
        return productList;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public boolean deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        for (Product p : productList) {
            if (product.getId() == p.getId()) {
                productList.set(productList.indexOf(p), product);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
