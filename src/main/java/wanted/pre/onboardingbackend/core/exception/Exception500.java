package wanted.pre.onboardingbackend.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import wanted.pre.onboardingbackend.dto.ResponseDTO;

@Getter
public class Exception500 extends RuntimeException {
    public Exception500(String message) {
        super(message);
    }

    public ResponseDTO<?> body() {
        return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, getMessage());
    }

    public HttpStatus status() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
