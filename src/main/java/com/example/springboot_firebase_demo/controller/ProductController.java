package com.example.springboot_firebase_demo.controller;

import com.example.springboot_firebase_demo.entity.Product;
import com.example.springboot_firebase_demo.entity.ProductSearchRequest;
import com.example.springboot_firebase_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.saveproduct(product);
    }

    @GetMapping("/products/{name}")
    public Product getProductsByName(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productService.getProductDetailsByName(name);
    }

    @GetMapping("/products")
    public List<Product> getProduct() throws ExecutionException, InterruptedException {
        return productService.getProductDetails();
    }


    @PutMapping("/products")
    public String updateProducts(@PathVariable String name, @RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.updateProductDetails(name, product);
    }

    @DeleteMapping("/products/{name}")
    public String deleteProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productService.deleteProduct(name);
    }

    @GetMapping("/products/{price}")
    public ResponseEntity<List<Product>> getProductListBasedGreaterThanPrice(@PathVariable double price) throws ExecutionException, InterruptedException {
        List<Product> result = productService.getProductListBasedGreaterThanPrice(price);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/products/batch")
    public ResponseEntity<String>  performBatchOperations(@RequestParam String prodToDelete, @RequestBody Product productToAdd,   @RequestBody Product productToUpdate) throws ExecutionException, InterruptedException {
        String result = productService.performBatchOperations(prodToDelete, productToUpdate, productToAdd);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/products/advancedSearch")
    public ResponseEntity<List<Product>> advancedSearchProduct(@RequestBody ProductSearchRequest productSearchRequest) throws ExecutionException, InterruptedException {
        List<Product> products = productService.advancedSearchProduct(productSearchRequest);
        return ResponseEntity.ok(products);
    }


}
