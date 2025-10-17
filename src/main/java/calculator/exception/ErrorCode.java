package calculator.exception;

public enum ErrorCode {

    NEGATIVE_NUMBER("음수는 허용되지 않습니다: "),
    INVALID_DELIMITER_FORMAT("구분자 형식이 올바르지 않습니다: "),
    UNSUPPORTED_PARSER_FORMAT("지원하지 않는 파서 형식입니다: "),
    INVALID_NUMBER_FORMAT("유효하지 않은 값이 포함되어 있습니다: ");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(String value) {
        return message + value;
    }
}
