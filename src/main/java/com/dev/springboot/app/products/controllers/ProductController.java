package com.dev.springboot.app.products.controllers;

import com.dev.springboot.app.products.models.entity.Product;
import com.dev.springboot.app.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private Environment env;

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> list() {
        return productService.findAll().stream().map(product -> {
            product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/view/{id}")
    public Product detail(@PathVariable Long id) {
        Product product = productService.findById(id);
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return product;
    }
}
