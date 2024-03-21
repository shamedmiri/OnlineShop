package ir.miri.shop.app.services.orders;


import ir.miri.shop.app.entities.orders.OrderItem;
import ir.miri.shop.app.repositories.orders.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository ;


    public OrderItem getById(long id){
        Optional<OrderItem> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public OrderItem add(OrderItem data){
        return repository.save(data);
    }
    public OrderItem update(OrderItem data) throws Exception {
        OrderItem oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setCount(data.getCount());
        oldData.setPrice(data.getPrice());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        OrderItem oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
