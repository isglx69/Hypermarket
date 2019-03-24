package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Sale;

import java.util.List;

public interface SaleService {
    public Sale addSale(Sale sale, boolean useHibernate);
    public Sale getSaleById(Long id);
    public List<Sale> getAllSales();
    public Sale updateSale(Sale sale);
    public void deleteSale(Sale sale);
}
