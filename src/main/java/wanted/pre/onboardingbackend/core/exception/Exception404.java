package wanted.pre.onboardingbackend.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import wanted.pre.onboardingbackend.dto.ResponseDTO;


@Getter
public class Exception404 extends RuntimeException {
    public Exception404(String message) {
        super(message);
    }

    public ResponseDTO<?> body() {
        return new ResponseDTO<>(HttpStatus.NOT_FOUND, getMessage());
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}