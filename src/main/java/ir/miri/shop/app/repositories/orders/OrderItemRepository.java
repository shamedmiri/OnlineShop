package ir.miri.shop.app.repositories.orders;

import ir.miri.shop.app.entities.orders.OrderItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem,Long> {
    Optional<OrderItem> findById(long id);

    OrderItem save(OrderItem data);

    void deleteById(long id);
}
