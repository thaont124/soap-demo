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
@XmlAccessorType(XmlAccessType.FIELD) //thong bao jaxb field de map
@XmlRootElement(name = "updateUserRequest", namespace = "http://example.com/user") // danh dau phan tu goc file xml
public class UpdateUserRequest {
    @XmlElement(name = "id", required = true)
    private String id;

    @XmlElement(name = "fullName")
    private String fullName;

    @XmlElement(name = "age")
    private Integer age;
}
