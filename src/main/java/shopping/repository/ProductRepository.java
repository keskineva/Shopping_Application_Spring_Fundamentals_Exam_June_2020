package shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.model.entity.CategoryName;
import shopping.model.entity.Product;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Collection<Product> findAllProductsByCategoryCategoryName(CategoryName category);

}
