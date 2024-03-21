package ir.miri.shop.app.services.people;


import ir.miri.shop.app.entities.people.Customer;
import ir.miri.shop.app.repositories.people.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getById(long id) {
        Optional<Customer> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Customer add(Customer data) {
        return repository.save(data);
    }

    public Customer update(Customer data) throws Exception {
        Customer oldData = getById(data.getId());
        if (oldData == null)
            throw new Exception("d");
        oldData.setAddress(data.getAddress());
        oldData.setEmail(data.getEmail());
        oldData.setFirstName(data.getFirstName());
        oldData.setLastName(data.getLastName());
        oldData.setMobile(data.getMobile());
        oldData.setPostalCode(data.getPostalCode());
        oldData.setTel(data.getTel());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws Exception {
        Customer oldData = getById(id);
        if (oldData == null)
            throw new Exception("sd");
        repository.deleteById(id);
        return true;
    }
}
