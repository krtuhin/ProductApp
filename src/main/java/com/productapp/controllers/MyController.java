package com.productapp.controllers;

import com.productapp.entities.Product;
import com.productapp.services.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MyController {

    @Autowired
    private ProductService productService;

    //show home page
    @RequestMapping("/")
    public String home(Model model) {

        //show page title
        model.addAttribute("title", "Home Page");

        //get product from database
        List<Product> list = this.productService.getAllProducts();

        if (list.size() == 0) {

            //if don't have any product then show this message
            model.addAttribute("msg", "You don't have any product..!");

        } else {
            //get all product from database
            model.addAttribute("list", list);
        }

        return "index";
    }

    //show add product page
    @RequestMapping("/add")
    public String addProduct(Model model) {

        //page title
        model.addAttribute("title", "Add Product");

        return "add_product";
    }

    //submit add product page and redirect to home page
    @RequestMapping(path = "/save-product", method = RequestMethod.POST)
    public RedirectView saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

        //save data into database using service class
        this.productService.createProduct(product);

        //go back to previous page
        return new RedirectView(request.getContextPath() + "/");
    }

    //delete product and redirect
    @RequestMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id, HttpServletRequest request) {

        //delete product using service class
        this.productService.deleteProduct(id);

        return new RedirectView(request.getContextPath() + "/");
    }

    //update product page
    @RequestMapping(path = {"/update/{id}"})
    public String update(@PathVariable("id") int id, Model model) {

        model.addAttribute("title", "Update Product");

        //get single product from data base using product id
        Product p = this.productService.getSingleProduct(id);

        //send data to view
        model.addAttribute("p", p);

        return "update_product";
    }

    //update product and redirect to home page
    @RequestMapping(path = "/update-product", method = RequestMethod.POST)
    public RedirectView updateProduct(
            @ModelAttribute Product product,
            HttpServletRequest request) {

        System.out.println("this is update data : " + product);

        //update product
        this.productService.updateProduct(product);

        return new RedirectView(request.getContextPath() + "/");
    }
}
