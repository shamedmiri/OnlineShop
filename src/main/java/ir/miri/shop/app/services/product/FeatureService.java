package ir.miri.shop.app.services.product;

import ir.miri.shop.app.entities.products.Feature;
import ir.miri.shop.app.repositories.product.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository repository ;

    public Feature getById(long id){
        Optional<Feature> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public Feature add(Feature data){
        return repository.save(data);
    }
    public Feature update(Feature data) throws Exception {
        Feature oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setValue(data.getValue());
        oldData.setKey(data.getKey());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Feature oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
