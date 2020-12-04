package io.omnirio.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.omnirio.customerservice.models.User;
import io.omnirio.customerservice.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String getWelcomeMessage() {
		return "CustomerMicroservice";
	}

	@GetMapping("/customer")
	List<User> getAllUsers() {
		return customerRepository.findAll();
	}

	@PostMapping("/customer")
	User AddUser(@RequestBody User newUser) {
		return customerRepository.save(newUser);
	}
}

