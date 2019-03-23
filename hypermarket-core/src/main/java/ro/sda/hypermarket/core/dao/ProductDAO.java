package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductDAO {
    Session getCurrentSession();
    Product getById(Long id);
    List<Product> getAll();
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
}
