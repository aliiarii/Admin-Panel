package com.aliari.service.impl;

import com.aliari.core.dto.product.ProductCreateRequest;
import com.aliari.core.dto.product.ProductResponse;
import com.aliari.core.dto.product.ProductUpdateRequest;
import com.aliari.repository.data.ProductRepository;
import com.aliari.repository.entity.Category;
import com.aliari.repository.entity.Product;
import com.aliari.service.CategoryService;
import com.aliari.service.util.MappingProduct;
import com.aliari.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	@Override
	public void save(ProductCreateRequest request) {
		var categoryResponse = categoryService.findById(request.categoryId());
		if (categoryResponse == null) {
			throw new IllegalArgumentException("Category not found");
		}
		var category = Category.builder()
				.id(categoryResponse.id())
				.name(categoryResponse.name())
				.description(categoryResponse.description())
				.build();
		var product = MappingProduct.toProduct(request, category);
		productRepository.save(product);
	}

	@Override
	public void update(ProductUpdateRequest request) {
		var existingProduct = productRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Product not found"));
		existingProduct.setName(request.name());
		existingProduct.setDescription(request.description());
		existingProduct.setPrice(request.price());
		existingProduct.setStock(request.stock());
		UUID categoryId = request.categoryId();
		Optional<Category> category = categoryService.findCategoryById(categoryId);
		existingProduct.setCategory(category.orElseThrow(() -> new RuntimeException("Category not found")));
		productRepository.save(existingProduct);
	}

	@Override
	public void delete(UUID id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ProductResponse> findAll() {
		var products = productRepository.findAll();
		return products.stream().map(MappingProduct::toProductResponse).toList();
	}

	@Override
	public List<Product> findByIds(List<UUID> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public Optional<Product> findById(UUID id) {
		return productRepository.findById(id);
	}
}
