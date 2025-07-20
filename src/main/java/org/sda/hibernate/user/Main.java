package org.sda.hibernate.user;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();

        System.out.println("Going to save a new user!");
        User user = new User();
        user.setName("Gledis");
        user.setEmail("gledislami@gmail.com");

        dao.save(user);

        System.out.println("Saved user: " + user + " succesfully!");

        System.out.println("Going to update the email");

        user.setEmail("lamigledi@gmail.com");
        dao.update(user);
        System.out.println("Updated user succesfully: " + user);

        List<User> users = dao.findAll();

        for (User u : users){
            System.out.println(u);
        }

        System.out.println("Going to delete");

        dao.delete(user.getId());

        System.out.println("User deleted succesfully");
    }
}
