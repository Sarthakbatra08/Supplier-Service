package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;
import com.learning.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping
	public SupplierResponse postSupplier(@RequestBody SupplierRequest supplierRequest) {
		return supplierService.createSupplier(supplierRequest);
	}

	@GetMapping("/{id}")
	public SupplierResponse getSupplierById(@PathVariable Long id) {
		return supplierService.findSupplierById(id);
	}

	@PutMapping("/{id}")
	public SupplierResponse updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest supplierRequest) {
		return supplierService.updateSupplier(id, supplierRequest);
	}

	@DeleteMapping("/{id}")
	public Status deleteSupplier(@PathVariable Long id) {
		return supplierService.deleteSupplier(id);
	}
}
