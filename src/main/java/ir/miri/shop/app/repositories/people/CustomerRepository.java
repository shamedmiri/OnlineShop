package ir.miri.shop.app.repositories.people;

import ir.miri.shop.app.entities.people.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Optional<Customer> findById(long id);

    Customer save(Customer data);

    void deleteById(long id);
}
