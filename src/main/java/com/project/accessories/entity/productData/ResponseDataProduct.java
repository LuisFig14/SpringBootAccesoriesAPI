package com.project.accessories.entity.productData;

import com.project.accessories.entity.Classification;
import com.project.accessories.entity.Material;

public record ResponseDataProduct(

        Long id,
        String name,
        String description,
        String color,
        Classification classification,
        Material material) {

}
