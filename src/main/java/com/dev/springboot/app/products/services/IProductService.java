package com.dev.springboot.app.products.services;

import com.dev.spring.app.commons.models.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product create(Product product);

    void deleteById(Long id);
}
