package ro.sda.hypermarket.core.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean   /* Semnalam ca aceasta interfata nu este un bean de Spring */
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    public T findById(long id);
//    @Query hibernate query language de cautat (HQL -hibernate query lanugage

}
