package ro.sda.hypermarket.core.service;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductService {
    Session getCurrentSession();
    public Product getById(Long id);
    public List<Product> getAll();
    public Product createProduct(Product product,boolean useHibernate);
    public Product updateProduct(Product product);
    public void deleteProduct(Product product);
}
