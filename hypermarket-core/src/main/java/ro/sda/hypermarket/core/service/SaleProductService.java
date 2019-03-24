package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.SaleProduct;

import java.util.List;

public interface SaleProductService {
    public SaleProduct addSaleProduct(SaleProduct saleProduct, boolean useHibernate);
    public SaleProduct getSaleProductById(Long id);
    public List<SaleProduct> getAllSaleProducts();
    public SaleProduct updateSaleProduct(SaleProduct saleProduct);
    public void deleteSaleProduct(SaleProduct saleProduct);
}
