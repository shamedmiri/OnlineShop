package ir.miri.shop.app.controllers.api.order;

import ir.miri.shop.app.entities.orders.Invoice;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.orders.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService service;


    @GetMapping("/{id}")
    public ServiceResponse<Invoice> search(@PathVariable long id) {
        try {
            Invoice result = service.getById(id);
            return new ServiceResponse<Invoice>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
        }

    }
    @GetMapping("/find")
    public ServiceResponse<Invoice> find(@RequestParam long cid) {
        try {
            List<Invoice> result = service.findByCustomer(cid);
            return new ServiceResponse<Invoice>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Invoice> add(@RequestBody Invoice Invoice) {
        try {
            Invoice result = service.add(Invoice);
            return new ServiceResponse<Invoice>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Invoice> update(@RequestBody Invoice Invoice) {
        try {
            Invoice result = service.update(Invoice);
            return new ServiceResponse<Invoice>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
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
