package com.example.Demo_ORM.DaoImpl;

import com.example.Demo_ORM.Dao.DAO;
import com.example.Demo_ORM.HibernateUtil.HibernateUtil;
import com.example.Demo_ORM.Entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDaoImpl  implements DAO<Users> {
    @Override
    public void addUser(Users user) {
        Session session=null;
        Transaction tx=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            session.persist(user);
            tx.commit();
            System.out.println("user OK");
        }catch(Exception e){
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Users> listUsers() {
        return null;
    }

    @Override
    public List<Users> UsersParMc(String mc) {
        return null;
    }

    @Override
    public Users getUser(Long id) {
        Users user=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            user=session.get(Users.class,id);
            System.out.println("user DONE");
        }catch(Throwable t){
            t.printStackTrace();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
        return user;
    }

    @Override
    public void updateUser(Long id,String NewName) {
        Users user=null;
        Session session=null;
        Transaction tx=null;

        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            user=session.get(Users.class,id);
            user.setUsername(NewName);
            tx.commit();
            System.out.println("user modifier");
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
           e.printStackTrace();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        Session session=null;
        Users  user=session.get(Users.class,id);
        session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(user);
    }


}
