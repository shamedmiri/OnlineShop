package ir.miri.shop.app.services.product;

import ir.miri.shop.app.entities.products.Size;
import ir.miri.shop.app.repositories.product.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeService {
    @Autowired
    private SizeRepository repository ;

    public Size getById(long id){
        Optional<Size> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public Size add(Size data){
        return repository.save(data);
    }
    public Size update(Size data) throws Exception {
        Size oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Size oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
