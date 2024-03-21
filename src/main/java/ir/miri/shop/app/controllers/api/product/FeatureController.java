package ir.miri.shop.app.controllers.api.product;


import ir.miri.shop.app.entities.products.Feature;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    @Autowired
    private FeatureService service;


    @GetMapping("/{id}")
    public ServiceResponse<Feature> search(@PathVariable long id) {
        try {
            Feature result = service.getById(id);
            return new ServiceResponse<Feature>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Feature>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Feature> add(@RequestBody Feature Feature) {
        try {
            Feature result = service.add(Feature);
            return new ServiceResponse<Feature>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Feature>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Feature> update(@RequestBody Feature Feature) {
        try {
            Feature result = service.update(Feature);
            return new ServiceResponse<Feature>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Feature>(e);
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
