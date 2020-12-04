package io.omnirio.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.omnirio.customerservice.models.User;

public interface CustomerRepository extends JpaRepository<User, Long> {

	
}
