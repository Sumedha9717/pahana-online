package com.pahana.Service;

import com.pahana.Dao.LoginDao;

import com.pahana.Model.*;

import java.util.List;

public class LoginService {
    private static  LoginService  instance;
    private static LoginDao loginDao;

    private  LoginService()
    {

        this.loginDao = new LoginDao();

    }

    public static LoginService getInstance() {
        if (instance == null)
        {
            synchronized (LoginService.class) {
                if (instance == null) {
                    instance = new LoginService();
                }
            }
        }
        return instance;
    }


}





