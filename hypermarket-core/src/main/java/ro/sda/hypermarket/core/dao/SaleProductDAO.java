package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.SaleProduct;
import java.util.List;

public interface SaleProductDAO {
    public SaleProduct addSaleProduct(SaleProduct saleProduct);
    public SaleProduct getSaleProductById(Long id);
    public List<SaleProduct> getAllSaleProducts();
    public SaleProduct updateSaleProduct(SaleProduct saleProduct);
    public void deleteSaleProduct(SaleProduct saleProduct);
}
