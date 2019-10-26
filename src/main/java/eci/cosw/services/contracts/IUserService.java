package eci.cosw.services.contracts;


import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import eci.cosw.factory.DatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    List<User> getUsers();
    User getUserByEmail(String email);
    void deleteAll();
    void save(User user);

}
