package com.ruan.test03;

import java.io.Serializable;

/**
 * @PackgeName: com.ruan.test03
 * @ClassName: User
 * @Author: 小天才
 * Date: 2021/7/1 7:51
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 用户对象
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1l;
    private String userName;
    private String pwd;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }
}
