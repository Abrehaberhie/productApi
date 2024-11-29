package com.reventure.Api.service;

import com.reventure.Api.entitiy.Product;

import java.awt.print.Book;
import java.util.List;

public interface ProductService {
    public String createProduct(Product product);

    public Product findProductById(Integer pId);

    public List<Product> findAllProduct();
    public Product updateProduct(Product product);
    public String deletProductById(Integer pId);
}