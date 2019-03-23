package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Sale;
import java.util.List;

public interface SaleDAO {
    public Sale addSale(Sale sale);
    public Sale getSaleById(Long id);
    public List<Sale> getAllSales();
    public Sale updateSale(Sale sale);
    public void deleteSale(Sale sale);
}
