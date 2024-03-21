package ir.miri.shop.app.controllers.api.product;


import ir.miri.shop.app.entities.products.Product;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping("/{id}")
    public ServiceResponse<Product> search(@PathVariable long id) {
        try {
            Product result = service.getById(id);
            return new ServiceResponse<Product>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }

    }

    @GetMapping("/find")
    public ServiceResponse<Product> find(@RequestParam long cid) {
        try {
            List<Product> result = service.findAllByCategory(cid);
            return new ServiceResponse<Product>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Product> add(@RequestBody Product Product) {
        try {
            Product result = service.add(Product);
            return new ServiceResponse<Product>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }
    }

    @GetMapping("")
    public ServiceResponse<Product> search(@RequestParam String keyword) {
        try {
            List<Product> result = service.search(keyword);
            return new ServiceResponse<Product>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Product> update(@RequestBody Product Product) {
        try {
            Product result = service.update(Product);
            return new ServiceResponse<Product>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
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
