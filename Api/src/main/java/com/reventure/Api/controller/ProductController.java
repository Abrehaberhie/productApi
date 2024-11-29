package com.reventure.Api.controller;

import com.reventure.Api.entitiy.Product;
import com.reventure.Api.service.ProductSrviceIpmle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/product")
public class ProductController {
    @Autowired
    private ProductSrviceIpmle productSrviceIpmle;
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product)
    {
        String status = productSrviceIpmle.createProduct(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED );
    }
    @GetMapping("/{bid}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer pId)
    {
        Product product= productSrviceIpmle.findProductById(pId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List<Product> products = productSrviceIpmle.findAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateBook(@RequestBody Product product)
    {
        Product product1 = productSrviceIpmle.updateProduct(product);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletProduct(@PathVariable Integer pId)
    {
        String status= productSrviceIpmle.deletProductById(pId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
