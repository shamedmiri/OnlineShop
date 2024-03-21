package ir.miri.shop.app.repositories.orders;

import ir.miri.shop.app.entities.orders.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice,Long> {
    @Query("from Invoice where customer.id=:customerId")
    List<Invoice> findAllByCustomer(long customerId);

    Optional<Invoice> findById(long id);

    Invoice save(Invoice data);

    void deleteById(long id);
}
