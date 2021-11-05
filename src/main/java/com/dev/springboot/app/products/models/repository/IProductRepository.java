package com.dev.springboot.app.products.models.repository;

import com.dev.springboot.app.products.models.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
}
