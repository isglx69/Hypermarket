package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductDAO {
    Session getCurrentSession();

    public Product getById(Long id);

    public List<Product> getAll();

    public Product createProduct(Product product);

    public Product updateProduct(Product product);

    public void deleteProduct(Product product);
}
