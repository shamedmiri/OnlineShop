package ir.miri.shop.app.controllers.api.site;

import ir.miri.shop.app.entities.site.Nav;
import ir.miri.shop.app.entities.site.Slider;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Slider")
public class SliderController {
    @Autowired
    private SliderService service;

    @GetMapping("")
    public ServiceResponse<Slider> search() {
        try {
            List<Slider> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Slider> search(@PathVariable long id) {
        try {
            Slider result = service.getById(id);
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }

    }
    @PostMapping("/changeOrder/{id}/{direction}")
    public ServiceResponse<Slider> changeOrder(@PathVariable long id,@PathVariable int direction) {
        try {
            Slider result = service.changeOrder(id,direction);
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }
    }
    @GetMapping("/getAll")
    public ServiceResponse<Slider> getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
        try {
            List<Slider> result = service.getAll(pageSize,pageNumber);
            long totalCount=service.getAllCount();
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS,totalCount);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }
    }
    @PostMapping("/")
    public ServiceResponse<Slider> add(@RequestBody Slider Slider) {
        try {
            Slider result = service.add(Slider);
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }
    }
    @PutMapping("/")
    public ServiceResponse<Slider> update(@RequestBody Slider Slider) {
        try {
            Slider result = service.update(Slider);
            return new ServiceResponse<Slider>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
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
