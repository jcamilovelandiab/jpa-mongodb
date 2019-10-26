package eci.cosw.services.contracts;

import eci.cosw.data.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ITodoService {

    List<Todo> getTodos();
    Optional<Todo> getTodoById(String id);
    List<Todo> getTodoByResponsible(String responsibleEmail);
    void save(Todo todo);
    void deleteAll();

}
