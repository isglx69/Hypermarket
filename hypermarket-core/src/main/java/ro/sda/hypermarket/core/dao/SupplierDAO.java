package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Supplier;
import java.util.List;

public interface SupplierDAO {
    public Supplier addSupplier(Supplier supplier);
    public Supplier getSupplierById(Long id);
    public List<Supplier> getAllSuppliers();
    public Supplier updateSupplier(Long id);
    public void deleteSupplier(Long id);
}
