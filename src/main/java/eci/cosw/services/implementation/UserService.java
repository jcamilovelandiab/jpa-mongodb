package eci.cosw.services.implementation;

import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import eci.cosw.data.repositories.UserRepository;
import eci.cosw.factory.DatabaseFactory;
import eci.cosw.services.contracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        User user = DatabaseFactory.getMongoOperation().findOne(query, User.class);
        return user;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public List<User> usersWithMoreThanTwoTodo(){
        List<User> userList = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (User user: userList) {
            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(user.getEmail()));
            List<Todo> todo = DatabaseFactory.getMongoOperation().find(query, Todo.class);
            if(todo.size()>2) users.add(user);
        }
        return users;
    }

    public void save(User user){
        userRepository.save(user);
    }

}
