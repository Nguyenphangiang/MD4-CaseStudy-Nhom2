package com.example.md4casestudynhom2.service.supplierAge;


import com.example.md4casestudynhom2.model.supplier_age.SupplierAge;
import com.example.md4casestudynhom2.service.IGeneralService;

public interface ISupplierAgeSV extends IGeneralService<SupplierAge> {

    Iterable<SupplierAge> getSupplierByAgeBetween(Long age1, Long age2);
}
