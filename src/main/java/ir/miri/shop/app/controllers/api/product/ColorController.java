package ir.miri.shop.app.controllers.api.product;


import ir.miri.shop.app.entities.products.Color;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.product.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {
    @Autowired
    private ColorService service;


    @GetMapping("/{id}")
    public ServiceResponse<Color> search(@PathVariable long id) {
        try {
            Color result = service.getById(id);
            return new ServiceResponse<Color>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Color> add(@RequestBody Color Color) {
        try {
            Color result = service.add(Color);
            return new ServiceResponse<Color>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
        }
    }
    @GetMapping("/")
    public ServiceResponse<Color> getAll(){
        try {
            List<Color> result = service.getAll();
            return new ServiceResponse<Color>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Color> update(@RequestBody Color Color) {
        try {
            Color result = service.update(Color);
            return new ServiceResponse<Color>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
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
