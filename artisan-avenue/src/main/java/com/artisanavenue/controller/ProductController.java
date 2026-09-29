package com.artisanavenue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.artisanavenue.entity.Product;
import com.artisanavenue.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Enable CORS to allow requests from the frontend
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. Get all products (READ ALL)
    @GetMapping
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // 2. Get a single product by ID (READ BY ID)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Add a new product (CREATE)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productRepository.save(product);
    }

    // 4. Update an existing product (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product productDetails) {

        return productRepository.findById(id).map(existingProduct -> {

            existingProduct.setName(productDetails.getName());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setStockQuantity(productDetails.getStockQuantity());
            existingProduct.setUnit(productDetails.getUnit());
            existingProduct.setIsActive(productDetails.getIsActive());
            existingProduct.setCategory(productDetails.getCategory());

            return ResponseEntity.ok(productRepository.save(existingProduct));

        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. Delete a product (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        if (productRepository.existsById(id)) {

            productRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}



//Role of the Controller (Bridge Between Backend and Frontend)
//After creating the database and repository, we created the ProductController.
//Its job is to accept requests from the outside world, mainly from the React Frontend, such as HTTP requests (GET, POST, PUT, DELETE).
//The Controller passes these requests to the Repository, gets the required result, and sends the response back to the frontend in JSON format.