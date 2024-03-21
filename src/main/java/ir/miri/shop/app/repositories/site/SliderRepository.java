package ir.miri.shop.app.repositories.site;

import ir.miri.shop.app.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SliderRepository extends PagingAndSortingRepository<Slider,Long> {
    List<Slider> findAllByEnableIsTrue(Sort sort);

    Optional<Slider> findById(long id);

    Slider save(Slider data);

    void deleteById(long id);

    long count();

    Slider findTopByItemOrder(int itemOrder);

    Slider findTopByOrderByItemOrderDesc();
}
