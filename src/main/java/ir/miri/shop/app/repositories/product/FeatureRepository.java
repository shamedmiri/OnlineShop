package ir.miri.shop.app.repositories.product;

import ir.miri.shop.app.entities.products.Feature;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends PagingAndSortingRepository<Feature,Long> {
    Optional<Feature> findById(long id);

    Feature save(Feature data);

    void deleteById(long id);
}
