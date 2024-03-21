package ir.miri.shop.app.controllers.api.product;


import ir.miri.shop.app.entities.products.Size;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    private SizeService service;


    @GetMapping("/{id}")
    public ServiceResponse<Size> search(@PathVariable long id) {
        try {
            Size result = service.getById(id);
            return new ServiceResponse<Size>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Size>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Size> add(@RequestBody Size Size) {
        try {
            Size result = service.add(Size);
            return new ServiceResponse<Size>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Size>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Size> update(@RequestBody Size Size) {
        try {
            Size result = service.update(Size);
            return new ServiceResponse<Size>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Size>(e);
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
