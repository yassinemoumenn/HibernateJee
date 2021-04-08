package com.example.Demo_ORM.Dao;

import com.example.Demo_ORM.Entity.Users;

import java.util.List;

public interface DAO<T> {
    public void addUser (T user);
    public List<T> listUsers();
    public List<T> UsersParMc(String mc);
    public T getUser(Long id);
    public void updateUser(Long id,String NewName);
    public void deleteUser(Long id);

}
