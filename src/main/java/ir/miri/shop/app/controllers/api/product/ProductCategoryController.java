package ir.miri.shop.app.controllers.api.product;


import ir.miri.shop.app.entities.products.ProductCategory;
import ir.miri.shop.app.entities.site.Slider;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService service;


    @GetMapping("/{id}")
    public ServiceResponse<ProductCategory> search(@PathVariable long id) {
        try {
            ProductCategory result = service.getById(id);
            return new ServiceResponse<ProductCategory>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
        }

    }
    @GetMapping("")
    public ServiceResponse<ProductCategory> search() {
        try {
            List<ProductCategory> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<ProductCategory>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
        }
    }

    @PostMapping("/")
    public ServiceResponse<ProductCategory> add(@RequestBody ProductCategory ProductCategory) {
        try {
            ProductCategory result = service.add(ProductCategory);
            return new ServiceResponse<ProductCategory>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<ProductCategory> update(@RequestBody ProductCategory ProductCategory) {
        try {
            ProductCategory result = service.update(ProductCategory);
            return new ServiceResponse<ProductCategory>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
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
