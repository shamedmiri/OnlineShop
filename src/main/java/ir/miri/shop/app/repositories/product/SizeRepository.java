package ir.miri.shop.app.repositories.product;

import ir.miri.shop.app.entities.products.Size;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SizeRepository extends PagingAndSortingRepository<Size,Long> {
    Optional<Size> findById(long id);

    Size save(Size data);

    void deleteById(long id);
}
