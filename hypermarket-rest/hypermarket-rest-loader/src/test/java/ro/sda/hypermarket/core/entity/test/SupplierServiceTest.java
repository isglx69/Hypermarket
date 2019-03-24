package ro.sda.hypermarket.core.entity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.dao.SupplierDAOImpl;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.SupplierService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    @Rollback(false)
    public void testAddSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("Cristi");
        supplier.setContactNo("0755111222");
        supplier.setCity("IASI");
        supplierService.addSupplier(supplier, false);

        Supplier supplier2 = new Supplier();
        supplier2.setName("Vasile");
        supplier2.setContactNo("0755333444");
        supplier2.setCity("BUCURESTI");
        supplierService.addSupplier(supplier2, false);
    }

    @Test
    public void getAllSuppliers() {
        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
        System.out.println(allSuppliers);
    }

    @Test
    public void testDeleteSupplier() {
        Long foundId = 5L;
        Supplier supplier = supplierService.getSupplierById(foundId);
        supplierService.deleteSupplier(supplier);
    }

    @Test
    public void testUpdateSupplier() {
        Long foundId = 1L;
        Supplier supplier = supplierService.getSupplierById(foundId);
        supplier.setCity("CLUJ-NAPOCA");
        supplierService.updateSupplier(supplier);
    }
}
