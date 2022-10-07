package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.Table;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from User"); //drop table users | delete from User
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Drop");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(new User(name,lastName,age));
            session.getTransaction().commit();
            session.close();
            System.out.println("Save");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("delete from  users where id = "+id).executeUpdate();
            transaction.commit();
            System.out.println(id + " " + "удален пользователь с id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> userList = session.createQuery("from User").list();
            session.getTransaction().commit();
            session.close();
            System.out.println("Found " + userList + " users");
            return userList;
        } catch (Exception r) {
            System.out.println(r.getMessage());
        }

        return null;
    }

    @Override
    public void cleanUsersTable() {
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query =  session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Clean");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
