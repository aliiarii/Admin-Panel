package com.aliari.service.util;

import com.aliari.core.dto.product.ProductCreateRequest;
import com.aliari.core.dto.product.ProductResponse;
import com.aliari.repository.entity.Category;
import com.aliari.repository.entity.Product;

import java.util.UUID;

public class MappingProduct {
	private MappingProduct(){
		throw new IllegalStateException("Utility class");
	}

	public static Product toProduct(ProductCreateRequest request, Category category){
		return Product.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.price(request.price())
				.stock(request.stock())
				.category(category)
				.build();
	}

	public static ProductResponse toProductResponse(Product product){
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.stock(product.getStock())
				.categoryId(product.getCategory().getId())
				.categoryName(product.getCategory().getName())
				.build();
	}
}
