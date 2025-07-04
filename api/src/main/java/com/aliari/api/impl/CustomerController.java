package com.aliari.api.impl;

import com.aliari.api.CustomerApi;
import com.aliari.core.dto.customer.CustomerCreateRequest;
import com.aliari.core.dto.customer.CustomerResponse;
import com.aliari.core.dto.customer.CustomerUpdateRequest;
import com.aliari.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {
	private final CustomerService service;

	@Override
	public ResponseEntity<CustomerResponse> save(CustomerCreateRequest request) {
		service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<CustomerResponse> update(CustomerUpdateRequest request) {
		service.update(request);
		return null;
	}

	@Override
	public ResponseEntity<CustomerUpdateRequest> delete(UUID id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<List<CustomerResponse>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
