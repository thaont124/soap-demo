package hnt.example.dto.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "createUserRequest", namespace = "http://example.com/user")
public class CreateUserRequest {
    @XmlElement(name = "fullName", required = true)
    private String fullName;

    @XmlElement(name = "age", required = true)
    private Integer age;
}
