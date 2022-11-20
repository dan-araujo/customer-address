package com.design.pattern.java.spring.project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.pattern.java.spring.project.model.Address;
import com.design.pattern.java.spring.project.model.AddressRepository;
import com.design.pattern.java.spring.project.model.Customer;
import com.design.pattern.java.spring.project.model.CustomerRepository;
import com.design.pattern.java.spring.project.service.CustomerService;
import com.design.pattern.java.spring.project.service.ViaCEPService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ViaCEPService viaCEPService;

	@Override
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}

	@Override
	public void add(Customer customer) {
		saveCustomerWithCEP(customer);

	}

	@Override
	public void update(Long id, Customer customer) {
		// Search Customer by in ID in database, if there is
		Optional<Customer> customerInDB = customerRepository.findById(id);
		if (customerInDB.isPresent()) {
			saveCustomerWithCEP(customer);
		}

	}

	@Override
	public void delete(Long id) {
		customerRepository.deleteById(id);

	}

	private void saveCustomerWithCEP(Customer customer) {
		// Check if the Customer Address already exists (by Cep)
		String cep = customer.getAddress().getCep();
		Address address = addressRepository.findById(cep).orElseGet(() -> {
			Address newAddress = viaCEPService.consultCEP(cep);
			addressRepository.save(newAddress);
			return newAddress;
		});
		// Insert Customer link the Adress (new or existing)
		customer.setAddress(address);
		customerRepository.save(customer);
	}

}
