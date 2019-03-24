package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Supplier;

public interface SupplierRepository extends EntityRepository<Supplier> {
    public Supplier findByName(String name);
}
