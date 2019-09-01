package com.ktc;

import java.lang.reflect.Array;

public class UserModel {

    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;



    public UserModel(String passwordVal,  String emailVal, String firstNameVal, String lastNameVal, boolean activeVal, int roleVal) {
        this.password = passwordVal;
        this.user  = new User();
        this.user.setEmail(emailVal);
        this.user.setFirstName(firstNameVal);
        this.user.setLastName(lastNameVal);
        this.user.setActive(activeVal);
        this.user.setRole(roleVal);

    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
