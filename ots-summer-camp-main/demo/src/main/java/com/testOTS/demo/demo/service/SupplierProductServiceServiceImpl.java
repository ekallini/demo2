package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.SupplierProductServiceRepository;
import com.testOTS.demo.demo.entity.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierProductServiceServiceImpl implements SupplierProductServiceService {

    private SupplierProductServiceRepository supplierProductServiceRepository;

    @Autowired
    public SupplierProductServiceServiceImpl(SupplierProductServiceRepository supplierProductServiceRepository) {
        this.supplierProductServiceRepository = supplierProductServiceRepository;
    }

    @Override
    public List<SupplierProductService> findAll() {
        return supplierProductServiceRepository.findAll();
    }

    @Override
    public SupplierProductService findById(long theId) {
        Optional<SupplierProductService> result = supplierProductServiceRepository.findById(theId);

        SupplierProductService theSupplierProductService = null;

        if (result.isPresent()) {
            theSupplierProductService = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find product-service id - " + theId);
        }

        return theSupplierProductService;
    }

    @Override
    public void save(SupplierProductService theSupplierProductService) {
        supplierProductServiceRepository.save(theSupplierProductService);
    }

    @Override
    public void deleteById(long theId) {
        supplierProductServiceRepository.deleteById(theId);
    }
}
