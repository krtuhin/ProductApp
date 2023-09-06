package com.productapp.services;

import com.productapp.dao.ProductDao;
import com.productapp.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    //method for save product using dao class
    public void createProduct(Product product) {
        productDao.saveProduct(product);
    }

    //method for update product using dao class
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    //method for delete product using dao class
    public void deleteProduct(int id) {
        this.productDao.deleteProduct(id);
    }

    //method for get single product using dao class
    public Product getSingleProduct(int id) {
        Product p = this.productDao.getProduct(id);
        return p;
    }

    //method for get all product using dao class
    public List<Product> getAllProducts() {
        List<Product> list = this.productDao.getAllProducts();
        return list;
    }
}
