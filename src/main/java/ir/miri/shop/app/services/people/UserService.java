package ir.miri.shop.app.services.people;

import ir.miri.shop.app.entities.people.User;
import ir.miri.shop.app.helper.utils.SecurityUtils;
import ir.miri.shop.app.repositories.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository ;
    @Autowired
    private SecurityUtils securityUtils;
    public User auth(String username,String password){
        //TODO: hash password
        password=securityUtils.encryptSHA1(password);
        return repository.findFirstByUserNameAndPassword(username,password);
    }
    public User getByUsername(String username){
        return repository.findFirstByUserName(username);
    }

    public User getById(long id){
        Optional<User> data =repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }
    public User add(User data){
        return repository.save(data);
    }
    public User update(User data) throws Exception {
        User oldData = getById(data.getId());
        if(oldData==null)
            throw new Exception("d");
        oldData.setEnable(data.isEnable());
        oldData.setEmail(data.getEmail());
        oldData.setPassword(data.getPassword());
        oldData.setLastName(data.getLastName());
        oldData.setName(data.getName());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws Exception {
        User oldData=getById(id);
        if(oldData == null)
            throw new Exception("sd");
         repository.deleteById(id);
         return true;
    }
    public User changePassword(long id,String oldPassword,String newPassword) throws Exception {
        oldPassword=securityUtils.encryptSHA1(oldPassword);
        newPassword=securityUtils.encryptSHA1(newPassword);
        User user = getById(id);
        if(user==null)
            throw new Exception("user error!!");
        if(!user.getPassword().equals(oldPassword))
            throw new Exception("invalid old password");
        user.setPassword(newPassword);
        return repository.save(user);
    }
}
