package com.gisela.praktikum01.entity;

/**
 * Created by Shiroinu on 2/25/2018.
 */

public class User {
    private int id;
    private int fullname;
    private int email;
    private int password;
    private int allocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFullname() {
        return fullname;
    }

    public void setFullname(int fullname) {
        this.fullname = fullname;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAllocation() {
        return allocation;
    }

    public void setAllocation(int allocation) {
        this.allocation = allocation;
    }
}
