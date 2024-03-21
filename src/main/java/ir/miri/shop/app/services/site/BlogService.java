package ir.miri.shop.app.services.site;

import ir.miri.shop.app.entities.site.Blog;
import ir.miri.shop.app.repositories.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository ;
    public List<Blog> search(String keyword){
        return  repository.findAllByTitleContainsOrDescriptionContains(keyword);
    }
    public Blog getById(long id){
        Optional<Blog> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public Blog add(Blog data) throws Exception {
        if(data.getTitle()==null || data.getTitle().equals(""))
            throw new Exception("Add Blog Error");
        return repository.save(data);
    }
    public Blog update(Blog data) throws Exception {
        Blog oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setBlogStatus(data.getBlogStatus());
        return repository.save(oldData);
    }
    public Blog increaseVisitedCount(long id) throws Exception {
        Blog oldData = getById(id);
        if(oldData==null)
            throw new Exception("d");
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Blog oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
