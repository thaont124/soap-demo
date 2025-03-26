package hnt.example.exception.user;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException {
    private String message;
    private int status;
    public UserNotFoundException(){
        this.message = "User not found";
        this.status = 404;
    }
}
