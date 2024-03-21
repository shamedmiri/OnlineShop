package ir.miri.shop.app.repositories.product;

import ir.miri.shop.app.entities.products.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query("from Product where productCategory.id= :categoryId")
    List<Product> findAllByCategory(long categoryId);
    @Query("from Product where enable=true and title like concat('%',:search,'%') or description like concat('%',:search,'%')")
    List<Product> findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(String search);

    Product save(Product oldData);

    void deleteById(long id);

    Optional<Product> findById(long id);
}
