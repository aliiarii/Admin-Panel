package com.aliari.core.dto.product;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProductResponse(
		UUID id,
		String name,
		String description,
		double price,
		int stock,
		UUID categoryId,
		String categoryName
) {
}
