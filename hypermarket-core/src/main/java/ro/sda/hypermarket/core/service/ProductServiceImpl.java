package ro.sda.hypermarket.core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.repository.ProductRepository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Service("productService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product getById(Long id) {
        return getCurrentSession().byId(Product.class).getReference(id);
    }

    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Product> criteriaQuery = session.getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);
        List<Product> allProducts = session.createQuery(criteriaQuery).getResultList();
        return allProducts;
    }

    @Override
    @Transactional
    public Product createProduct(Product product,boolean useHibernate) {
        getCurrentSession().save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Product product1 = getById(product.getId());
        sessionFactory.getCurrentSession().merge(product1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Product product1 = getById(product.getId());
        sessionFactory.getCurrentSession().delete(product1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
