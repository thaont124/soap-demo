package hnt.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hnt.example.dto.request.CreateUserRequest;
import hnt.example.dto.request.UpdateUserRequest;
import hnt.example.dto.response.UserResponse;
import hnt.example.entity.User;
import hnt.example.exception.user.UserNotFoundException;
import hnt.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getFullName(), user.getAge()))
                .collect(Collectors.toList());
    }

    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(updateUserRequest.getFullName() != null){
            user.setFullName(updateUserRequest.getFullName());
        }

        if(updateUserRequest.getAge() != null) {
            user.setAge(updateUserRequest.getAge());
        }
        userRepository.save(user);
        return objectMapper.convertValue(user, UserResponse.class);
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return new UserResponse(user.getId(), user.getFullName(), user.getAge());
    }

    public UserResponse createUser(CreateUserRequest updateUserRequest) {
        User user = objectMapper.convertValue(updateUserRequest, User.class);
        userRepository.save(user);
        return objectMapper.convertValue(user, UserResponse.class);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }else {
            userRepository.deleteById(id);
        }
    }
}