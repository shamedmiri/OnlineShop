package ir.miri.shop.app.services.orders;


import ir.miri.shop.app.entities.orders.Invoice;
import ir.miri.shop.app.repositories.orders.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repository ;

    public List<Invoice> findByCustomer(long id){
        return repository.findAllByCustomer(id);
    }

    public Invoice getById(long id){
        Optional<Invoice> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public Invoice add(Invoice data){
        return repository.save(data);
    }
    public Invoice update(Invoice data) throws Exception {
        Invoice oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setPayedDate(data.getPayedDate());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        Invoice oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
}
