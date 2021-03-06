package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.ProductCategories;

import java.util.List;

public interface ProductCategoryDAO {
    Session getCurrentSession();
    public ProductCategories getById(Long id);
    public List<ProductCategories> getAll();
    public ProductCategories createProductCategory(ProductCategories productCategory);
    public ProductCategories updateProductCategory (ProductCategories productCategory);
    public void deleteProductCategory(ProductCategories productCategory);
}
