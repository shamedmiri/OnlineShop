package ir.miri.shop.app.services.product;

import ir.miri.shop.app.entities.products.Color;
import ir.miri.shop.app.repositories.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    private ColorRepository repository ;

    public Color getById(long id){
        Optional<Color> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public List<Color> getAll(){
        return repository.findAll();
    }
    public Color add(Color data){
        return repository.save(data);
    }
    public Color update(Color data) throws Exception {
        Color oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setValue(data.getValue());
        oldData.setName(data.getName());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Color oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
