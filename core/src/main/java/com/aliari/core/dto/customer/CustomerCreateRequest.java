package com.aliari.core.dto.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CustomerCreateRequest(
		@NotBlank(message = "Firstname is required field")
		String firstname,
		@NotBlank(message = "Lastname is required field")
		String lastname,
		@NotBlank(message = "Email is required field")
		String email,
		@NotBlank(message = "Phone is required field")
		String phone,
		@NotBlank(message = "Address is required field")
		String address
) {
}
