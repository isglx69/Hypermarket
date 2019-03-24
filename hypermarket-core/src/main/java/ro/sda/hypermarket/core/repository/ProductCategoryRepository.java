package ro.sda.hypermarket.core.repository;


import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.ProductCategories;

public interface ProductCategoryRepository extends EntityRepository<ProductCategories> {
    public ProductCategories findByName(String name);
}
