package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public Supplier addSupplier(Supplier supplier, boolean useHibernate);
    public Supplier getSupplierById(Long id);
    public List<Supplier> getAllSuppliers();
    public Supplier updateSupplier(Supplier supplier);
    public void deleteSupplier(Supplier supplier);
}
