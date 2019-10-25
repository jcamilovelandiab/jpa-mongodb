package eci.cosw;

import eci.cosw.data.model.User;
import eci.cosw.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import eci.cosw.config.AppConfiguration;
import eci.cosw.data.model.Customer;
import eci.cosw.data.repositories.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        userRepository.save(new User("alice.smith@mail.com", " AliceSmith"));
        userRepository.save(new User("bob.marley@mail.com", "Bob Marley"));
        userRepository.save(new User("jimmy.page@mail.com", "Jimmy Page"));
        userRepository.save(new User("freddy.mercury@mail.com", "Freddy Mercury"));
        userRepository.save(new User("michael.jackson@mail.com", "Michael Jackson"));

        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

    }

}