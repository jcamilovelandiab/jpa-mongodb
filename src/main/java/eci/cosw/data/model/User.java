package eci.cosw.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    @DateTimeFormat
    private String date;

    public User(String email, String name){
        this.email = email;
        this.name = name;
        this.date = String.valueOf(new Date());
    }

}
