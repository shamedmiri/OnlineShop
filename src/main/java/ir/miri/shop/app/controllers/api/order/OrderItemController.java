package ir.miri.shop.app.controllers.api.order;

import ir.miri.shop.app.entities.orders.OrderItem;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.orders.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService service;


    @GetMapping("/{id}")
    public ServiceResponse<OrderItem> search(@PathVariable long id) {
        try {
            OrderItem result = service.getById(id);
            return new ServiceResponse<OrderItem>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<OrderItem>(e);
        }

    }


    @PostMapping("/")
    public ServiceResponse<OrderItem> add(@RequestBody OrderItem OrderItem) {
        try {
            OrderItem result = service.add(OrderItem);
            return new ServiceResponse<OrderItem>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<OrderItem>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<OrderItem> update(@RequestBody OrderItem OrderItem) {
        try {
            OrderItem result = service.update(OrderItem);
            return new ServiceResponse<OrderItem>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<OrderItem>(e);
        }
    }

    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<Boolean>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Boolean>(e);
        }
    }
   

}
