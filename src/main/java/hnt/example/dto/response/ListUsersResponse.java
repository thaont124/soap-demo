package hnt.example.dto.response;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getUsersResponse") // danh dau phan tu goc file xml
public class ListUsersResponse {

    @XmlElementWrapper(name = "users")  // Bao bọc danh sách
    @XmlElement(name = "user")  // Ánh xạ từng UserResponse thành thẻ <user>
    private List<UserResponse> users;


}