package org.example;

import org.example.config.MyConfig;
import org.example.model.User;
import org.example.service.Communication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);

        User addUser = new User(3L, "James", "Brown", (byte) 23);
        communication.saveUser(addUser);

        User updateUser = new User(3L, "Thomas", "Shelby", (byte) 21);
        communication.updateUser(updateUser);

        communication.deleteUser(3L);
    }
}
