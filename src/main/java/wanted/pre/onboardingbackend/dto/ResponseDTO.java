package wanted.pre.onboardingbackend.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDTO<T> {
    private Integer status; // HTTP 상태 코드

    private String msg; // 에러 발생 시 에러 제목으로 표시

    private T data; // 성공 시 응답할 내용, 에러 발생 시 표시할 구체적인 에러 내용

    public ResponseDTO() {
        this.status = HttpStatus.OK.value();
        this.msg = "ok";
    }

    public ResponseDTO(T data) {
        this.status = HttpStatus.OK.value();
        this.msg = "ok";
        this.data = data; // Response Body
    }

    public ResponseDTO(HttpStatus httpStatus, String msg, T data) {
        this.status = httpStatus.value();
        this.msg = msg; // 에러 제목
        this.data = data; // 에러 내용
    }
}
