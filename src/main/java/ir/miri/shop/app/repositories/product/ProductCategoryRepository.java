package ir.miri.shop.app.repositories.product;

import ir.miri.shop.app.entities.products.ProductCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory,Long> {
    List<ProductCategory> findAllByEnableIsTrue(Sort sort);

    Optional<ProductCategory> findById(long id);

    ProductCategory save(ProductCategory data);

    void deleteById(long id);
}
