package ir.miri.shop.app.services.product;

import ir.miri.shop.app.entities.products.Product;
import ir.miri.shop.app.entities.site.Blog;
import ir.miri.shop.app.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository ;
    public List<Product> findAllByCategory(long categoryId){
        return  repository.findAllByCategory(categoryId);
    }
    public List<Product> search(String keyword){
        return  repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(keyword);
    }
    public Product getById(long id){
        Optional<Product> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public Product add(Product data){
        return repository.save(data);
    }
    public Product update(Product data) throws Exception {
        Product oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setEnable(data.isEnable());
        oldData.setExist(data.isExist());
        oldData.setPrice(data.getPrice());
        oldData.setColors(data.getColors());
        oldData.setSizes(data.getSizes());
        oldData.setFeatures(data.getFeatures());

        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Product oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
    public Product increaseVisitedCount(long id) throws Exception {
        Product oldData = getById(id);
        if(oldData==null)
            throw new Exception("d");
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }
}
