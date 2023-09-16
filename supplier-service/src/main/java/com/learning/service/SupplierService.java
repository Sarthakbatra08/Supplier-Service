package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.SupplierEntity;
import com.learning.enums.Status;
import com.learning.globalException.SupplierResponseException;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;
import com.learning.repository.SupplierRepository;
import com.learning.utils.Convertor;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private Convertor convertor;

	public SupplierResponse createSupplier(SupplierRequest supplierRequest) {
		SupplierResponse supplierResponse = null;
		if (Objects.nonNull(supplierRequest)) {
			SupplierEntity supplierEntity = convertor.requestToEntity(supplierRequest);
			supplierEntity = supplierRepository.save(supplierEntity);
			supplierResponse = convertor.entityToResponse(supplierEntity);
		}
		return supplierResponse;
	}

	public SupplierResponse findSupplierById(Long id) {
		return supplierRepository.findById(id).map(convertor::entityToResponse)
				.orElseThrow(() -> new SupplierResponseException("Supplier Not Found"));
	}

	public SupplierResponse updateSupplier(Long id, SupplierRequest supplierRequest) {
		return supplierRepository.findById(id).map(supplierEntity -> {
			supplierEntity = convertor.updateEntity(supplierRequest, supplierEntity);
			supplierEntity = supplierRepository.save(supplierEntity);
			return convertor.entityToResponse(supplierEntity);
		}).orElseThrow(() -> new SupplierResponseException("Supplier Not Found"));
	}

	public Status deleteSupplier(Long id) {
		Optional<SupplierEntity> optionalEntity = supplierRepository.findById(id);
		if (Objects.nonNull(optionalEntity)) {
			supplierRepository.deleteById(id);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}
	
//	public SupplierResponse findSupplierById(Long id) {
//	SupplierResponse supplierResponse = null;
//	Optional<SupplierEntity> optionalEntity = supplierRepository.findById(id);
//	if (optionalEntity.isPresent()) {
//		SupplierEntity supplierEntity = optionalEntity.get();
//		supplierResponse = convertor.entityToResponse(supplierEntity);
//		return supplierResponse;
//	}
//	return null;
//}

//public SupplierResponse updateSupplier(Long id, SupplierRequest supplierRequest) {
//	SupplierResponse supplierResponse = null;
//	Optional<SupplierEntity> optionalEntity = supplierRepository.findById(id);
//	if (optionalEntity.isPresent()) {
//		SupplierEntity supplierEntity = optionalEntity.get();
//		supplierEntity = convertor.updateEntity(supplierRequest, supplierEntity);
//		supplierEntity = supplierRepository.save(supplierEntity);
//		supplierResponse = convertor.entityToResponse(supplierEntity);
//		return supplierResponse;
//	}
//	return null;
//}
}
