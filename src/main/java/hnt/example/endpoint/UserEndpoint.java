package hnt.example.endpoint;

import hnt.example.dto.request.CreateUserRequest;
import hnt.example.dto.request.GetByIdRequest;
import hnt.example.dto.request.UpdateUserRequest;
import hnt.example.dto.response.ListUsersResponse;
import hnt.example.dto.response.UserResponse;
import hnt.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/user";

    private final UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public UserResponse createUser(@RequestPayload CreateUserRequest user) {
        return userService.createUser(user);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsers")
    @ResponsePayload
    public ListUsersResponse getUsers() {
        return new ListUsersResponse(userService.getUsers());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserById")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload GetByIdRequest request) {
        return userService.getUser(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UserResponse updateUser(@RequestPayload UpdateUserRequest user) {
        return userService.updateUser(user.getId(), user);
    }


}
