package ir.miri.shop.app.controllers.api.site;

import ir.miri.shop.app.entities.site.Nav;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.site.NavService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Nav")
public class NavController {
    @Autowired
    private NavService service;

    @GetMapping("")
    public ServiceResponse<Nav> search() {
        try {
            List<Nav> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }
    @GetMapping("/getAll")
    public ServiceResponse<Nav> getAll(@RequestParam Integer pageSize,@RequestParam Integer pageNumber) {
        try {
            List<Nav> result = service.getAll(pageSize,pageNumber);
            long totalCount=service.getAllCount();
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS,totalCount);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Nav> gatById(@PathVariable long id) {
        try {
            Nav result = service.getById(id);
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Nav> add(@RequestBody Nav Nav) {
        try {
            Nav result = service.add(Nav);
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }
    @PostMapping("/changeOrder/{id}/{direction}")
    public ServiceResponse<Nav> changeOrder(@PathVariable long id,@PathVariable int direction) {
        try {
            Nav result = service.changeOrder(id,direction);
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }
    @PutMapping("/")
    public ServiceResponse<Nav> update(@RequestBody Nav Nav) {
        try {
            Nav result = service.update(Nav);
            return new ServiceResponse<Nav>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
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
