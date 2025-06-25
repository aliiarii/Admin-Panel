package com.aliari.api;

import com.aliari.core.dto.order.OrderCreateRequest;
import com.aliari.core.dto.order.OrderResponse;
import com.aliari.core.dto.order.OrderUpdateRequest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface OrderApi {
	@PostMapping
	ResponseEntity<String> save(
			@RequestBody @Valid OrderCreateRequest request);

	@GetMapping
	ResponseEntity<List<OrderResponse>> findAll();

	@DeleteMapping("/{id}")
	ResponseEntity<OrderResponse> delete(
			@PathVariable UUID id
	);

	@PutMapping
	ResponseEntity<OrderResponse> update(
			@RequestBody @Valid OrderUpdateRequest request
	);

	@GetMapping("/{id}")
	ResponseEntity<List<OrderResponse>> findByCustomerId(
			@PathVariable UUID id);
}
