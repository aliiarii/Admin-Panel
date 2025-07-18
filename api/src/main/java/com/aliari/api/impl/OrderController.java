package com.aliari.api.impl;

import com.aliari.api.OrderApi;
import com.aliari.core.dto.order.OrderCreateRequest;
import com.aliari.core.dto.order.OrderResponse;
import com.aliari.core.dto.order.OrderUpdateRequest;
import com.aliari.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController implements OrderApi {
	private final OrderService service;

	@Override
	public ResponseEntity<String> save(OrderCreateRequest request) {
		service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<List<OrderResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	public ResponseEntity<OrderResponse> delete(UUID id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<OrderResponse> update(OrderUpdateRequest request) {
		service.update(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<List<OrderResponse>> findByCustomerId(UUID id) {
		return ResponseEntity.ok(service.findByCustomerId(id));
	}
}
