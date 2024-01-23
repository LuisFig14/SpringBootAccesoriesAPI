package com.project.accessories.service;

import com.project.accessories.entity.Product;
import com.project.accessories.entity.productData.RegisterDataProduct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.accessories.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository; //instance of repository

    //Constructor of repository
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Methods

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con el ID: " + id));
    }

    public RegisterDataProduct createProduct (RegisterDataProduct registerDataProduct){

        productRepository.save(new Product(registerDataProduct));

        return registerDataProduct;
    }

    public Product updateProduct(Long id, Product productUpdated ){
        Product product = getProductById(id);

        product.setName(productUpdated.getName());
        product.setDescription(productUpdated.getDescription());
        product.setColor(productUpdated.getColor());
        product.setClassification(productUpdated.getClassification());
        product.setMaterial(productUpdated.getMaterial());
        product.setMeasure(productUpdated.getMeasure());
        product.setPrice(productUpdated.getPrice());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = getProductById(id);
        productRepository.delete(product);
    }


}
