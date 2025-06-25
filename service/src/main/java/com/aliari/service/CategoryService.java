package com.aliari.service;

import com.aliari.core.dto.category.CategoryCreateRequest;
import com.aliari.core.dto.category.CategoryResponse;
import com.aliari.core.dto.category.CategoryUpdateRequest;
import com.aliari.repository.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
	void save(CategoryCreateRequest request);

	boolean update(CategoryUpdateRequest request);

	void delete(UUID id);

	CategoryResponse findById(UUID id);

	Optional<Category> findCategoryById(UUID id);

	List<CategoryResponse> findAll();
}
