package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.SupplierProductService;

import java.util.List;

public interface SupplierProductServiceService {

    public List<SupplierProductService> findAll();

    public SupplierProductService findById(long theId);

    public void save(SupplierProductService supplierProductService);

    public void deleteById(long theId);
}
