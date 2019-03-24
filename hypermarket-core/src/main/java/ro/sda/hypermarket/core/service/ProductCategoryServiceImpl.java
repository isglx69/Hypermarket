package ro.sda.hypermarket.core.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.ProductCategories;
import ro.sda.hypermarket.core.repository.ProductCategoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Service("productCategoryService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductCategoryServiceImpl implements ProductCategoryService{

    private List<ProductCategories> productCategories = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ProductCategories getById(Long id) {
        return getCurrentSession().byId(ProductCategories.class).getReference(id);
    }

    @Override
    public List<ProductCategories> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<ProductCategories> criteriaQuery = session.getCriteriaBuilder().createQuery(ProductCategories.class);
        criteriaQuery.from(ProductCategories.class);
        List<ProductCategories> allProductCategories = session.createQuery(criteriaQuery).getResultList();
        return allProductCategories;
    }

    @Override
    @Transactional
    public ProductCategories createProductCategory(ProductCategories productCategory,boolean useHibernate) {
        getCurrentSession().save(productCategory);
        return productCategory;
    }

    @Override
    public ProductCategories updateProductCategory(ProductCategories productCategory) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        ProductCategories productCategory1 = getById(productCategory.getId());
        sessionFactory.getCurrentSession().merge(productCategory1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return productCategory;
    }
    @Override
    public void deleteProductCategory(ProductCategories productCategory) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        ProductCategories productCategory1 = getById(productCategory.getId());
        sessionFactory.getCurrentSession().delete(productCategory1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
