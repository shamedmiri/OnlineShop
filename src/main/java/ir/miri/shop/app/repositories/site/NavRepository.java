package ir.miri.shop.app.repositories.site;

import ir.miri.shop.app.entities.site.Nav;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NavRepository extends PagingAndSortingRepository<Nav,Long> {
    List<Nav> findAllByEnableIsTrue(Sort sort);

    Optional<Nav> findById(long id);
    Nav findTopByOrderByItemOrderDesc();

    Nav save(Nav data);

    void deleteById(long id);

    long count();
    Nav findTopByItemOrder(int itemOrder);
}
