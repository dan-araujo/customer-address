package com.design.pattern.java.spring.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.design.pattern.java.spring.project.model.Address;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCEPService {

	@GetMapping("/{cep}/json/")
	Address consultCEP(@PathVariable("cep") String cep);

}
