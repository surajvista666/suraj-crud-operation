package com.crudExample.crud;

import com.crudExample.crud.dao.UserRepository;
import com.crudExample.crud.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(CrudApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        //Creating a User.
        User user = new User();
        user.setName("Suraj");
        user.setAddress("Uttar Pradesh");
        user.setAge("24");
        user.setPhone("9044800767");
        user.setEmail("surajvista666@gmail.com");
        user.setStatus("Back End Developer");
        userRepository.save(user);

        //Read the user by id
        Optional<User> optional1 = userRepository.findById(11);
        User user2 = optional1.get();
        System.out.println("Id : " + user2.getId() +
                " Name = " + user2.getName() +
                " Age = " + user2.getAge() +
                " Address = " + user2.getAddress() +
                " Phone = " + user2.getPhone() +
                " E-Mail = " + user2.getEmail() +
                " Status = " + user2.getStatus());

		//Read All User
        Iterable<User> itr = userRepository.findAll();
        itr.forEach(user3 -> {
            System.out.println("Id : " + user3.getId() +
                    " Name = " + user3.getName() +
                    " Age = " + user3.getAge() +
                    " Address = " + user3.getAddress() +
                    " Phone = " + user3.getPhone() +
                    " E-Mail = " + user3.getEmail() +
                    " Status = " + user3.getStatus());
        });


        //Updating a User.
        Optional<User> optional = userRepository.findById(10);
        User user4 = optional.get();
        user4.setName("Ajeet Kumar Patel");
        User result = userRepository.save(user4);
        System.out.println("Update Successfull");

        //Delete a User.
        userRepository.deleteById(11);
        System.out.println("Successfull deleted User");

        //Delete All User
        userRepository.deleteAll();
        System.out.println("Successfull deleted All User");
    }
}