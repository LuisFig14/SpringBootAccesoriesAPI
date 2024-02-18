package com.project.accessories.controller;

import com.project.accessories.entity.Product;
import com.project.accessories.entity.productData.RegisterDataProduct;
import com.project.accessories.entity.productData.UpdateDateProduct;
import com.project.accessories.repository.ProductRepository;
import com.project.accessories.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
@CrossOrigin(origins = "http://localhost:4200") //acceso a cliente frontend (Angular)
public class ProductController {

    private final ProductService productService; //Service

    @Autowired
    ProductRepository productRepository;



    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get All (Read)
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //Get (Read)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //Post (Create)
    @PostMapping
    public ResponseEntity<RegisterDataProduct> createProduct(@RequestBody @Valid RegisterDataProduct registerDataProduct){

        RegisterDataProduct product = productService.createProduct(registerDataProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //Put (Update)
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct (@RequestBody @Valid UpdateDateProduct updateDateProduct){
        Product product = productService.updateProduct(updateDateProduct);

        return ResponseEntity.ok(new UpdateDateProduct(product.getId(), product.getName(), product.getDescription(),
        product.getColor()));
    }

    //Delete (Delete)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }




}
