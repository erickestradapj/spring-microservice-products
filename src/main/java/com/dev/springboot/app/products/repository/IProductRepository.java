package com.dev.springboot.app.products.repository;

import com.dev.spring.app.commons.models.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
}
