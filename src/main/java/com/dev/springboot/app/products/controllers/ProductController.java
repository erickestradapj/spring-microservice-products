package com.dev.springboot.app.products.controllers;

import com.dev.spring.app.commons.models.entity.Product;
import com.dev.springboot.app.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
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
    public Product detail(@PathVariable Long id) throws InterruptedException {

        if (id.equals(10L)) {
            throw new IllegalStateException("Product not found");
        }

        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(5L);
        }

        Product product = productService.findById(id);
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return product;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product edit(@RequestBody Product product, @PathVariable Long id) {
        Product productDB = productService.findById(id);
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());

        return productService.create(productDB);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
