package eci.cosw.services.implementation;

import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import eci.cosw.data.repositories.TodoRepository;
import eci.cosw.factory.DatabaseFactory;
import eci.cosw.services.contracts.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TodoService implements ITodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(String id){
        return todoRepository.findById(id);
    }

    public List<Todo> getTodoByResponsible(String responsibleEmail){
        return todoRepository.findByResponsibleEmail(responsibleEmail);
    }

    public void save(Todo todo){
        todoRepository.save(todo);
    }

    @Override
    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public List<Todo> getExpiredTodos(){
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(String.valueOf(new Date())));
        List<Todo> todos = DatabaseFactory.getMongoOperation().find(query, Todo.class);
        return todos;
    }

    /**
     * A todo is considered important if its priority is greater than Five
     * @return important todo list
     */
    public List<Todo> getImportantTodoList(){
        Query query = new Query();
        query.addCriteria(Criteria.where("priority").gte(5));
        List<Todo> todoList = DatabaseFactory.getMongoOperation().find(query, Todo.class);
        return todoList;
    }


}
