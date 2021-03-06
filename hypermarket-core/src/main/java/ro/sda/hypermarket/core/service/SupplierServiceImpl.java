package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.SupplierRepository;
import java.util.List;

@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public Supplier addSupplier(Supplier supplier, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.addSupplier(supplier);
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierDAO.getSupplierById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierDAO.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        supplierDAO.deleteSupplier(supplier);
    }
}
