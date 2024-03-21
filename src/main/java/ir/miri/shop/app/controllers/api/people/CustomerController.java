package ir.miri.shop.app.controllers.api.people;

import ir.miri.shop.app.entities.people.Customer;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.people.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;


    @GetMapping("/{id}")
    public ServiceResponse<Customer> search(@PathVariable long id) {
        try {
            Customer result = service.getById(id);
            return new ServiceResponse<Customer>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Customer>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Customer> add(@RequestBody Customer Customer) {
        try {
            Customer result = service.add(Customer);
            return new ServiceResponse<Customer>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Customer>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Customer> update(@RequestBody Customer Customer) {
        try {
            Customer result = service.update(Customer);
            return new ServiceResponse<Customer>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Customer>(e);
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
