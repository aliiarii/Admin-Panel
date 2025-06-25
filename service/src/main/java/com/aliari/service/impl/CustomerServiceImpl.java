package com.aliari.service.impl;

import com.aliari.core.dto.customer.CustomerCreateRequest;
import com.aliari.core.dto.customer.CustomerResponse;
import com.aliari.core.dto.customer.CustomerUpdateRequest;
import com.aliari.repository.data.CustomerRepository;
import com.aliari.repository.entity.Customer;
import com.aliari.service.util.MappingCustomer;
import com.aliari.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	public void save(CustomerCreateRequest request) {
		var customer = MappingCustomer.toCustomer(request);
		customerRepository.save(customer);
	}

	@Override
	public boolean update(CustomerUpdateRequest request) {
		return customerRepository.findById(request.id()).map(customer -> {
			customer.setFirstname(request.firstname());
			customer.setLastname(request.lastname());
			customer.setEmail(request.email());
			customer.setPhone(request.phone());
			customer.setAddress(request.address());
			customerRepository.save(customer);
			return true;
		}).orElse(false);
	}

	@Override
	public List<CustomerResponse> findAll() {
		return customerRepository.findAll().stream().map(
				MappingCustomer::toCustomerResponse
		).toList();
	}

	@Override
	public Optional<Customer> findById(UUID uuid) {
		return customerRepository.findById(uuid);
	}

	@Override
	public void delete(UUID id) {
		Optional<Customer> existCustomer = customerRepository.findById(id);
		existCustomer.ifPresent(customerRepository::delete);
	}
}
