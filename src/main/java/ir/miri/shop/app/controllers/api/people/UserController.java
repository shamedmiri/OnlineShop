package ir.miri.shop.app.controllers.api.people;

import ir.miri.shop.app.config.JwtTokenUtil;
import ir.miri.shop.app.entities.people.User;
import ir.miri.shop.app.enums.ResponseStatus;
import ir.miri.shop.app.helper.exception.JwtTokenException;
import ir.miri.shop.app.helper.ui.ServiceResponse;
import ir.miri.shop.app.helper.ui.uimodels.people.UserVM;
import ir.miri.shop.app.services.people.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ServiceResponse<UserVM> login(@RequestBody User user) {
        User data = service.auth(user.getUserName(), user.getPassword());
        if (data == null)
            return new ServiceResponse<UserVM>(ResponseStatus.FAILED, "Username or password is incorrect");
        UserVM userVM = new UserVM(data);
        String token=jwtTokenUtil.generateToken(userVM);
        userVM.setToken(token);
        return new ServiceResponse<UserVM>(userVM, ResponseStatus.SUCCESS);

    }


    @GetMapping("/{id}")
    public ServiceResponse<UserVM> search(@PathVariable long id) {
        try {
            User result = service.getById(id);
            return new ServiceResponse<UserVM>(new UserVM(result), ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<UserVM>(e);
        }

    }
    @GetMapping("/getUserInfo")
    public ServiceResponse<UserVM> getUserInfo(HttpServletRequest servletRequest) {
        try {
            String requestTokenHeader=servletRequest.getHeader("Authorization");
            if(requestTokenHeader==null||!requestTokenHeader.startsWith("Bearer "))
                throw new JwtTokenException("request header dose not set");
            String token=requestTokenHeader.substring(7);
            String username=jwtTokenUtil.getUsernameFromToken(token);
            if(username==null)
                throw new JwtTokenException("user name csn not resolve");
            User result = service.getByUsername(username);
            return new ServiceResponse<UserVM>(new UserVM(result), ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<UserVM>(e);
        }

    }

    @PostMapping("/")
    public ServiceResponse<UserVM> add(@RequestBody User User) {
        try {
            User result = service.add(User);
            return new ServiceResponse<UserVM>(new UserVM(result), ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<UserVM>(e);
        }
    }
    @PutMapping("/")
    public ServiceResponse<UserVM> update(@RequestBody User User) {
        try {
            User result = service.update(User);
            return new ServiceResponse<UserVM>(new UserVM(result), ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<UserVM>(e);
        }
    }
    @PutMapping("/changePass")
    public ServiceResponse<UserVM> changePassword(@RequestBody UserVM data) {
        try {
            User result = service.changePassword(data.getId(), data.getPassword(), data.getNewPassword());
            return new ServiceResponse<UserVM>(new UserVM(result), ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<UserVM>(e);
        }
    }
    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<Boolean>(result, ResponseStatus.SUCCESS);
        } catch (Exception e) {
            return new ServiceResponse<Boolean>(e);
        }
    }



}
