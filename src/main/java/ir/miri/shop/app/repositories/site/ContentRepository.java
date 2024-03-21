package ir.miri.shop.app.repositories.site;

import ir.miri.shop.app.entities.site.Content;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content,Long> {
    Content findFirstByKey(String key);

    Optional<Content> findById(long id);

    Content save(Content data);

    void deleteById(long id);

    long count();
}
