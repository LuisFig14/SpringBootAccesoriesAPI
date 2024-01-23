package com.project.accessories.entity.productData;

import com.project.accessories.entity.Classification;
import com.project.accessories.entity.Material;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDataProduct(

        @NotBlank(message = "name required")
        String name,
        @NotBlank(message = "description required")
        String description,
        @NotBlank(message = "color required")
        String color,
        @NotNull
        Classification classification,
        @NotNull
        Material material,
        @NotBlank(message = "measures required")
        String measure,
        @NotNull
        double price

        ) {
}
