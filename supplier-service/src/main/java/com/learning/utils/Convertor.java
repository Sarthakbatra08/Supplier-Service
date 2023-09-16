package com.learning.utils;

import org.springframework.stereotype.Component;

import com.learning.entity.SupplierEntity;
import com.learning.model.SupplierRequest;
import com.learning.model.SupplierResponse;

@Component
public class Convertor {

	public SupplierEntity requestToEntity(SupplierRequest supplierRequest) {
		SupplierEntity supplierEntity = new SupplierEntity();
		supplierEntity.setName(supplierRequest.getName());
		supplierEntity.setAddress(supplierRequest.getAddress());
		supplierEntity.setUserId(supplierRequest.getUserId());
		return supplierEntity;
	}

	public SupplierResponse entityToResponse(SupplierEntity supplierEntity) {
		SupplierResponse supplierResponse = new SupplierResponse();
		supplierResponse.setSupplierId(supplierEntity.getSupplierId());
		supplierResponse.setName(supplierEntity.getName());
		supplierResponse.setAddress(supplierEntity.getAddress());
		supplierResponse.setUserId(supplierEntity.getUserId());
		return supplierResponse;
	}

	public SupplierEntity updateEntity(SupplierRequest supplierRequest, SupplierEntity supplierEntity) {
		supplierEntity.setName(supplierRequest.getName());
		supplierEntity.setAddress(supplierRequest.getAddress());
		supplierEntity.setUserId(supplierRequest.getUserId());
		return supplierEntity;
	}

}
