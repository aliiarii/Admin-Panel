package com.aliari.service;

import com.aliari.core.dto.product.ProductCreateRequest;
import com.aliari.core.dto.product.ProductResponse;
import com.aliari.core.dto.product.ProductUpdateRequest;
import com.aliari.repository.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
	void save(ProductCreateRequest request);

	void update(ProductUpdateRequest request);

	void delete(UUID id);

	List<ProductResponse> findAll();

	List<Product> findByIds(List<UUID> ids);

	Optional<Product> findById(UUID id);
}
