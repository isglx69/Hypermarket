@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierDaoTest {

    @Autowired
    private SupplierDao supplierDao;

    @Test
    public void testAddSupplier(){
        Supplier supplier = new Supplier();
        supplier.setName("Victor");
        supplier.setContactNo("07552225525");
        supplier.setCity("Iasi");
        supplierDao.createSupplier(supplier);

    }

    @Test
    public void getAllSuppliers(){
        List <Supplier> allSuppliers = supplierDao.getAllSuppliers();
        System.out.println(allSuppliers);
    }
//    @Test
//    public void findById(int supplierId){
//        Supplier supplier = new Supplier();
//        supplier.getId();
//
//
//    }