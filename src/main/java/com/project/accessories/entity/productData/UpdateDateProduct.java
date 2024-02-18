package com.project.accessories.entity.productData;

import com.project.accessories.entity.Classification;
import com.project.accessories.entity.Material;
import jakarta.validation.constraints.NotNull;

public record UpdateDateProduct(@NotNull Long id, String name, String description, String color) {
}
