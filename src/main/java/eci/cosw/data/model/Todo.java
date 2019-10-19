package eci.cosw.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Todo {

    @Id
    private String id;
    private String description;
    private Integer priority;
    private String dueDate;
    private String responsible;
    private String status;
}
