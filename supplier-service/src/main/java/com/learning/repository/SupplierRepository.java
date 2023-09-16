package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {

}
