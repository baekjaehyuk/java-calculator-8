package calculator.model;

import calculator.exception.ErrorCode;
import java.util.Arrays;

public class StringCalculator {

    private static final int NON_NEGATIVE_THRESHOLD = 0;
    private static final int EMPTY_RESULT = 0;

    public int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::toPositiveInt)
                .sum();
    }

    public int getEmptyResult() {
        return EMPTY_RESULT;
    }

    private int toPositiveInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < NON_NEGATIVE_THRESHOLD) {
                throw new IllegalArgumentException(ErrorCode.NEGATIVE_NUMBER.getMessage(value));
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_FORMAT.getMessage(value));
        }
    }
}
