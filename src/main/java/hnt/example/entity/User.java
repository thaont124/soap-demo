package hnt.example.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.time.Year;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Integer age;

//    private String getYearOfBirth() {
//        return String.valueOf(Year.now().getValue() - age);
//    }

}
