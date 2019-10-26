package eci.cosw.data.repositories;

import eci.cosw.data.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByDescription(String description);
    List<Todo> findByResponsibleEmail(String responsibleEmail);

}
