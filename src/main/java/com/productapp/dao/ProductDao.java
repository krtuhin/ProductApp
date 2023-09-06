package com.productapp.dao;

import com.productapp.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDao {

    @Autowired
    private HibernateTemplate template;

    //method for save product into database
    @Transactional
    public void saveProduct(Product product) {
        this.template.saveOrUpdate(product);
    }

    //method for update product into database
    @Transactional
    public void updateProduct(Product product) {
        this.template.update(product);
    }

    //method for delete product from database
    @Transactional
    public void deleteProduct(int id) {
        Product p = this.template.get(Product.class, id);
        this.template.delete(p);
    }

    //method for get single product from database
    public Product getProduct(int id) {
        Product p = this.template.get(Product.class, id);
        return p;
    }

    //method for get all products from database
    public List<Product> getAllProducts() {
        List<Product> list = this.template.loadAll(Product.class);
        return list;
    }
}
