package ir.miri.shop.app.services.site;

import ir.miri.shop.app.entities.site.Nav;
import ir.miri.shop.app.repositories.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NavService {
    @Autowired
    private NavRepository repository;

    public List<Nav> findAllOrderByItemOrder() {
        return (List<Nav>) repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }
    public List<Nav> getAll(Integer pageSize,Integer pageNumber) {
        Pageable page= PageRequest.of(pageNumber,pageSize,Sort.by("itemOrder"));
        Page<Nav> all = repository.findAll(page);
        return all.toList();
    }
    public long getAllCount() {
        return repository.count();
    }
    public Nav getById(long id) {
        Optional<Nav> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
    public Nav changeOrder(long id,int direction) throws Exception {
        Nav item=getById(id);
        if(item == null)
            throw new Exception("item not found!!");
        switch (direction){
            case 1:
                //UP
                if(item.getItemOrder()<=1)
                    return item;
                Nav siblingItem=repository.findTopByItemOrder(item.getItemOrder()-1);
                if(siblingItem==null)
                    item.setItemOrder(item.getItemOrder()-1);
                else{
                    item.setItemOrder(siblingItem.getItemOrder());
                    siblingItem.setItemOrder(item.getItemOrder()+1);
                    repository.save(siblingItem);
                }
                break;
            case 2:
                //DOWN
                Nav siblingItem2=repository.findTopByItemOrder(item.getItemOrder()+1);
                if(siblingItem2==null) {
                    Nav lastItemOrder= repository.findTopByOrderByItemOrderDesc();
                    if (item.getItemOrder()<lastItemOrder.getItemOrder())
                        item.setItemOrder(item.getItemOrder() + 1);
                } else{
                    item.setItemOrder(siblingItem2.getItemOrder());
                    siblingItem2.setItemOrder(item.getItemOrder()-1);
                    repository.save(siblingItem2);
                }
                break;
        }
        repository.save(item);
        return item;
    }

    public Nav add(Nav data) throws Exception {
        if(data.getTitle()==null||data.getTitle().equals(""))
            throw new Exception("Please enter title");
        else  if(data.getLink()==null||data.getLink().equals(""))
            throw new Exception("Please enter link");
           Nav lastItem= repository.findTopByOrderByItemOrderDesc();
           if(lastItem!=null&&lastItem.getItemOrder()>0)
               data.setItemOrder(lastItem.getItemOrder()+1);
           else
               data.setItemOrder(1);
        return repository.save(data);
    }

    public Nav update(Nav data) throws Exception {
        Nav oldData = getById(data.getId());
        if (oldData == null)
            throw new Exception("d");
        oldData.setTitle(data.getTitle());
        oldData.setEnable(data.isEnable());
        oldData.setItemOrder(data.getItemOrder());
        oldData.setLink(data.getLink());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws Exception {
        Nav oldData = getById(id);
        if (oldData == null)
            throw new Exception("sd");
        repository.deleteById(id);
        return true;
    }
}
