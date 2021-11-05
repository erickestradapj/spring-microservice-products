package com.dev.springboot.app.products.services;

import com.dev.springboot.app.products.models.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);
}
