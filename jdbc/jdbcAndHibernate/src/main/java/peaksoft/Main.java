package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //userDaoHibernate.createUsersTable();

        //userDaoHibernate.dropUsersTable();

//        userDaoHibernate.saveUser("Atabek","Dosbaev",(byte) 20);
//        userDaoHibernate.saveUser("Zamir","Atokurov",(byte) 20);
//        userDaoHibernate.saveUser("Ormon","Alizhanov",(byte) 20);

        //userDaoHibernate.removeUserById(3);

        //userDaoHibernate.getAllUsers();

        //userDaoHibernate.cleanUsersTable();

    }
}
