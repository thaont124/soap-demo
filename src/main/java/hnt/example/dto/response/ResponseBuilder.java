package hnt.example.dto.response;

import jakarta.annotation.Nonnull;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseBuilder {

    @Nonnull
    public static <T> ResponseEntity<ResponseDto<T>> okResponse(String message, String statusCode) {
        final ResponseDto<T> dto = ResponseDto.<T>builder()
                .message(message)
                .statusCode(statusCode)
                .build();
        return ResponseEntity.ok(dto);
    }

    public static <T> ResponseEntity<ResponseDto<T>> okResponse(String message, @Nonnull T body, String statusCode) {
        final ResponseDto<T> dto = ResponseDto.<T>builder()
                .message(message)
                .data(body)
                .statusCode(statusCode)
                .build();
        return ResponseEntity.ok(dto);
    }

    public static <T> ResponseEntity<ResponseDto<T>> internalErrorResponse(@Nonnull T body, String statusCode) {
        final ResponseDto<T> dto = ResponseDto.<T>builder()
                .data(body)
                .statusCode(statusCode)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }

    public static <T> ResponseEntity<ResponseDto<T>> notFoundErrorResponse(String message, String statusCode) {
        final ResponseDto<T> dto = ResponseDto.<T>builder()
                .message(message)
                .statusCode(statusCode)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }




}