package com.reventure.Api.service;

import com.reventure.Api.entitiy.Product;
import com.reventure.Api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSrviceIpmle implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product  created";
    }

    @Override
    public Product findProductById(Integer pId) {
      Optional<Product> pById= productRepository.findById(pId);
      if(pById.isPresent())
      {
          return pById.get();
      }
        return null;
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> products =productRepository.findAll();
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        Product updatedproduct =productRepository.save(product);
        return updatedproduct ;
    }

    @Override
    public String deletProductById(Integer pId) {
        productRepository.deleteById(pId);
        return "Product deleted";
    }

}
