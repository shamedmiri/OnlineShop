package ir.miri.shop.app.repositories.site;

import ir.miri.shop.app.entities.site.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    @Query("from Blog where title like concat('%',:search,'%') or description like concat('%',:search,'%') ")
    List<Blog> findAllByTitleContainsOrDescriptionContains(String search);

    Optional<Blog> findById(long id);

    Blog save(Blog data);

    void deleteById(long id);
}
