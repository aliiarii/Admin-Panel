package com.aliari.api.impl;

import com.aliari.api.CategoryApi;
import com.aliari.core.dto.category.CategoryCreateRequest;
import com.aliari.core.dto.category.CategoryResponse;
import com.aliari.core.dto.category.CategoryUpdateRequest;
import com.aliari.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {
	private final CategoryService categoryService;

	@Override
	public ResponseEntity<CategoryResponse> save(CategoryCreateRequest request) {
		categoryService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<CategoryResponse> update(CategoryUpdateRequest request) {
		categoryService.update(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<List<CategoryResponse>> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@Override
	public ResponseEntity<CategoryResponse> delete(UUID id){
		categoryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
