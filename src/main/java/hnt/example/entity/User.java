package hnt.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;

@Data
@Document(collection = "users")
//@Entity
public class User {
    @Id
    private String id;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String fullName;
    private Integer age;

//    private String getYearOfBirth() {
//        return String.valueOf(Year.now().getValue() - age);
//    }

}
