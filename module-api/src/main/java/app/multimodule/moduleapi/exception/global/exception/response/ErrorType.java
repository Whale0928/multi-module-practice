package app.multimodule.moduleapi.exception.global.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorType {
    NOT_VALID_TOKEN(401, "유효하지 않은 토큰입니다.");
    private final int code;
    private final String message;
}
