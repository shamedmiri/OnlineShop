package ir.miri.shop.app.controllers.api.site;

import ir.miri.shop.app.entities.site.Content;
import ir.miri.shop.app.entities.site.Nav;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.site.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    @Autowired
    private ContentService service;

    @GetMapping("")
    public ServiceResponse<Content> find(@RequestParam String keyword) {
        try {
            Content result = service.findByKey(keyword);
            return new ServiceResponse<Content>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
        }
    }
    @GetMapping("/getAll")
    public ServiceResponse<Content> getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
        try {
            List<Content> result = service.getAll(pageSize,pageNumber);
            long totalCount=service.getAllCount();
            return new ServiceResponse<Content>(result, ResponseStatus.SUCCESS,totalCount);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Content> search(@PathVariable long id) {
        try {
            Content result = service.getById(id);
            return new ServiceResponse<Content>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Content> add(@RequestBody Content Content) {
        try {
            Content result = service.add(Content);
            return new ServiceResponse<Content>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
        }
    }
    @PutMapping("/")
    public ServiceResponse<Content> update(@RequestBody Content Content) {
        try {
            Content result = service.update(Content);
            return new ServiceResponse<Content>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
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
