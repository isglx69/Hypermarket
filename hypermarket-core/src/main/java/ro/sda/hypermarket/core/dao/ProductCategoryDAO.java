package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.ProductCategories;

import java.util.List;

public interface ProductCategoryDAO {
    Session getCurrentSession();
    ProductCategories getById(Long id);
    List<ProductCategories> getAll();
    ProductCategories createProductCategory(ProductCategories productCategory);
    ProductCategories updateProductCategory (ProductCategories productCategory);
    void deleteProductCategory(ProductCategories productCategory);
}
