package ir.miri.shop.app.repositories.product;

import ir.miri.shop.app.entities.products.Color;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepository extends PagingAndSortingRepository<Color,Long> {

    List<Color> findAll();
    Optional<Color> findById(long id);

    Color save(Color data);

    void deleteById(long id);
}
