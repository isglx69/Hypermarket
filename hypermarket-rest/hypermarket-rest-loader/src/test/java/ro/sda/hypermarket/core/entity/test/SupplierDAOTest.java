package ro.sda.hypermarket.core.entity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAOImpl;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierDAOTest {

    @Autowired
    private SupplierDAOImpl supplierDAOImpl;

    @Test
    public void testCreate(){
        Supplier supplier = new Supplier();
        supplier.setName("Cristi");
        supplier.setContactNo("0755111222");
        supplier.setCity("IASI");
        supplierDAOImpl.addSupplier(supplier);
    }

    @Test
    public void getAllSuppliers(){
        List<Supplier> allSuppliers = supplierDAOImpl.getAllSuppliers();
        System.out.println(allSuppliers);
    }

//    @Test
//    public void findById(int supplierId){
//        Supplier supplier = new Supplier();
//        supplier.getId();
//
//
//    }
