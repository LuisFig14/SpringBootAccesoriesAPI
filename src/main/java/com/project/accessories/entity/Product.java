package com.project.accessories.entity;

import com.project.accessories.entity.productData.RegisterDataProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generation automatic of primary key
    private Long id;
    private String name;
    private String description;
    private String color;
    @Enumerated(EnumType.STRING)
    private Classification classification; //ENUM
    @Enumerated(EnumType.STRING)
    private Material material; //ENUM
    private String measure;
    private double price;



    //Constructor
    public Product(RegisterDataProduct registerDataProduct) {

        this.name = registerDataProduct.name();
        this.description =registerDataProduct.description();
        this.color = registerDataProduct.color();
        this.classification = registerDataProduct.classification();
        this.material = registerDataProduct.material();
        this.measure = registerDataProduct.measure();
        this.price = registerDataProduct.price();

    }
}
