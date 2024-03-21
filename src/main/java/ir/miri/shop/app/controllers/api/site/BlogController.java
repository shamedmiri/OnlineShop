package ir.miri.shop.app.controllers.api.site;

import ir.miri.shop.app.entities.site.Blog;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.services.site.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService service;

    @GetMapping("")
    public ServiceResponse<Blog> search(@RequestParam String keyword) {
        try {
            List<Blog> result = service.search(keyword);
            return new ServiceResponse<Blog>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Blog> search(@PathVariable long id) {
        try {
            Blog result = service.getById(id);
            return new ServiceResponse<Blog>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<Blog> add(@RequestBody Blog blog) {
        try {
            Blog result = service.add(blog);
            return new ServiceResponse<Blog>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }
    }
    @PutMapping("/")
    public ServiceResponse<Blog> update(@RequestBody Blog blog) {
        try {
            Blog result = service.update(blog);
            return new ServiceResponse<Blog>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
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
    @PutMapping("/increaseVisit/{id}")
    public ServiceResponse<Blog> update(@PathVariable long id) {
        try {
            Blog result = service.increaseVisitedCount(id);
            return new ServiceResponse<Blog>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }
    }

}
