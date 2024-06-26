package ir.miri.shop.app.helper.ui.uimodels.people;

import ir.miri.shop.app.entities.people.User;
import ir.miri.shop.app.enums.UserRole;

public class UserVM {
    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String newPassword;
    private UserRole role;
    private boolean enable;
    private String token;
    private String fullName;

    public UserVM() {
    }
    public UserVM(User user) {
        setEmail(user.getEmail());
        setId(user.getId());
        setName(user.getName());
        setLastName(user.getLastName());
        setRole(user.getRole());
        setEnable(user.isEnable());
        setUserName(user.getUserName());
        setFullName(user.getName()+" "+user.getLastName());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
