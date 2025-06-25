package com.aliari.core.dto.category;

import com.aliari.core.dto.product.ProductResponse;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CategoryResponse(
		UUID id,
		String name,
		String description,
		List<ProductResponse> productList
){
}
