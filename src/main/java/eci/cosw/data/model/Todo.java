package eci.cosw.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="todos")
public class Todo {

    @Id
    private String id;
    private String description;
    private Integer priority;
    private String dueDate;
    private String responsibleEmail;
    private String status;

    public Todo(String description, Integer priority, String dueDate, String responsibleEmail, String status){
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsibleEmail = responsibleEmail;
        this.status = status;
    }

}
