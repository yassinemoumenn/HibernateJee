package com.example.Demo_ORM.Dao;


import com.example.Demo_ORM.DaoImpl.UserDaoImpl;
import com.example.Demo_ORM.Entity.Users;

public class Test {

    public static void main(String[] args) {
        DAO dao =new UserDaoImpl();
        dao.addUser(new Users("yassine","moumen","yassinemoumen","123","admin"));
        //dao.updateUser(1L,"ggggg");
        //dao.deleteUser(3L);
        System.out.println("--------------------------------");

}
}