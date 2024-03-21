package ir.miri.shop.app.repositories.people;

import ir.miri.shop.app.entities.people.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findFirstByUserNameAndPassword(String username,String password);
    User findFirstByUserName(String username);

    Optional<User> findById(long id);

    User save(User data);

    void deleteById(long id);
}
