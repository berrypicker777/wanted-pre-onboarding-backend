package wanted.pre.onboardingbackend.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDTO<T> {
    private Integer status; // HTTP 상태 코드

    private T data; // 성공 시 응답할 내용, 에러 발생 시 표시할 구체적인 에러 내용

    public ResponseDTO() {
        this.status = HttpStatus.OK.value();
    }

    public ResponseDTO(T data) {
        this.status = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseDTO(HttpStatus httpStatus, T data) {
        this.status = httpStatus.value(); // HTTP 상태 코드
        this.data = data; // 에러 내용
    }
}
