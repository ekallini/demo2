package com.testOTS.demo.demo.rest;


import com.testOTS.demo.demo.entity.SupplierProductService;
import com.testOTS.demo.demo.service.SupplierProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierProductServiceRestController {

    private SupplierProductServiceService supplierProductServiceService;

    @Autowired
    public SupplierProductServiceRestController(SupplierProductServiceService supplierProductServiceService) {
        this.supplierProductServiceService = supplierProductServiceService;
    }

    @GetMapping("/supplierProductService")
    public List<SupplierProductService> findAll() {
        return supplierProductServiceService.findAll();
    }

    @GetMapping("/supplierProductService/{supplierProductServiceId}")
    public SupplierProductService getSupplierProductService(@PathVariable long supplierProductServiceId) {

        SupplierProductService supplierProductService = supplierProductServiceService.findById(supplierProductServiceId);

        if(supplierProductService == null) {
            throw new RuntimeException("Product/Service Id not found"+ supplierProductServiceId);
        }

        return supplierProductService;
    }

    @PostMapping("/supplierProductService")
    public SupplierProductService addSupplierProductService(@RequestBody SupplierProductService supplierProductService) {

        supplierProductService.setId(0);

        supplierProductServiceService.save(supplierProductService);

        return supplierProductService;
    }

    @PutMapping("/supplierProductService")
    public SupplierProductService updateSupplierProductService(@RequestBody SupplierProductService supplierProductService) {

        supplierProductServiceService.save(supplierProductService);

        return supplierProductService;
    }

    @DeleteMapping("/supplierProductService/{supplierProductServiceId}")
    public String deletesupplierProductService(@PathVariable long supplierProductServiceId) {

        SupplierProductService supplierProductService = supplierProductServiceService.findById(supplierProductServiceId);

        if (supplierProductService == null) {
            throw new RuntimeException("Product/Service id not found - " +supplierProductServiceId);
        }

        supplierProductServiceService.deleteById(supplierProductServiceId);

        return "Deleted product/service id - " + supplierProductServiceId;
    }
}
