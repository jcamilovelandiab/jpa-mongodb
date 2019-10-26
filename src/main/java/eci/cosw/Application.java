package eci.cosw;

import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import eci.cosw.data.repositories.TodoRepository;
import eci.cosw.data.repositories.UserRepository;
import eci.cosw.factory.DatabaseFactory;
import eci.cosw.services.contracts.ITodoService;
import eci.cosw.services.contracts.IUserService;
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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    ITodoService todoService;

    @Autowired
    IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.deleteAll(); todoService.deleteAll();
        // USERS
        List<User> users = new ArrayList<>(); users.add(new User("alice.smith@mail.com", " Allen Paul"));
        users.add(new User("bob.marley@mail.com", "Bob Marley"));
        users.add(new User("jimmy.page@mail.com", "Jimmy Page"));
        users.add(new User("freddy.mercury@mail.com", "Freddy Mercury"));
        users.add(new User("michael.jackson@mail.com", "Michael Jackson"));
        users.add(new User("allen.paul@mail.com", " Allen Paul"));
        users.add(new User("nikola.tesla@mail.com", "Nikola Tesla"));
        users.add(new User("elon.musk@mail.com", "Elon Musk"));
        users.add(new User("steve.jobs@mail.com", "Steve Jobs"));
        users.add(new User("albert.einstein@mail.com", "Albert Einstein"));
        users.add(new User("ramanujan@mail.com", "Ramanujan"));
        users.add(new User("bill.gates@mail.com", "Bill Gates"));
        for (User user: users) {
            userService.save(user);
        }
        System.out.println("-------------------------------");
        System.out.println("        All users found");
        System.out.println("-------------------------------");
        for (User user : userService.getUsers()) {
            System.out.println(user);
        }
        System.out.println();

        // TODO
        List<String> descriptions = new ArrayList<String>(); descriptions.add("Login"); descriptions.add("Sign Up");
        descriptions.add("Security"); descriptions.add("Map View"); descriptions.add("database deployment");
        List<String> statusList = new ArrayList<>();
        statusList.add("Ready"); statusList.add("In Progress"); statusList.add("Completed");
        for(int i=0; i<20; i++){
            int random = new Random().nextInt(100);
            String description = descriptions.get(random%(descriptions.size()));
            int priority = (random%10)+1;
            String dueDate = String.valueOf(createRandomDate(2015,2025));
            String responsibleEmail = users.get(random%(users.size())).getEmail();
            String status = statusList.get(random%(statusList.size()));
            Todo todo = new Todo(description, priority, dueDate, responsibleEmail, status);
            todoService.save(todo);
        }
        System.out.println("-------------------------------");
        System.out.println("        All todo found");
        System.out.println("-------------------------------");
        for (Todo todo : todoService.getTodos()) {
            System.out.println(todo);
        }
        System.out.println();
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static Date createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        LocalDate localDate = LocalDate.of(year, month, day);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

}