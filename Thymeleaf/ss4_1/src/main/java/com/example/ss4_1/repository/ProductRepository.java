package com.example.ss4_1.repository;

import com.example.ss4_1.model.Product;
import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> displayProducts() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteProduct(Product product) {
        entityManager.remove(findProductById(product.getId()));
    }

    @Override
    public Product displayProductDetails(int id) {
        return null;
    }

    @Override
    public List<Product> findProductByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.name = :name", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }
}
