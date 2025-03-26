package hnt.example.exception;

import hnt.example.dto.response.ResponseBuilder;
import hnt.example.dto.response.ResponseDto;
import hnt.example.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class AdviceController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseBuilder.notFoundErrorResponse(
                ex.getMessage(),
                "USER0404"
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Object>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(
                ResponseDto.builder()
                        .message("Validation failed")
                        .data(errors)
                        .statusCode("400")
                        .build()
        );
    }
}