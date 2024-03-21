package ir.miri.shop.app.services.product;

import ir.miri.shop.app.entities.products.ProductCategory;
import ir.miri.shop.app.repositories.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository ;
    public List<ProductCategory> findAllOrderByItemOrder(){
        return (List<ProductCategory>) repository.findAllByEnableIsTrue(Sort.by("id"));
    }
    public ProductCategory getById(long id){
        Optional<ProductCategory> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public ProductCategory add(ProductCategory data){
        return repository.save(data);
    }
    public ProductCategory update(ProductCategory data) throws Exception {
        ProductCategory oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setEnable(data.isEnable());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        ProductCategory oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
