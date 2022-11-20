package com.design.pattern.java.spring.project.service;

import com.design.pattern.java.spring.project.model.Customer;

public interface CustomerService {

	Iterable<Customer> findAll();

	Customer findById(Long id);

	void add(Customer customer);

	void update(Long id, Customer customer);

	void delete(Long id);
}
