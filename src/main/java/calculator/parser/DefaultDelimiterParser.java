package calculator.parser;

import java.util.Optional;
import java.util.regex.Pattern;

public class DefaultDelimiterParser implements Parser {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern DEFAULT_FORMAT_PATTERN = Pattern.compile("^[0-9,:]+$");

    @Override
    public Optional<String[]> parseInput(String input) {
        if (!DEFAULT_FORMAT_PATTERN.matcher(input).matches()) {
            return Optional.empty();
        }
        return Optional.of(input.split(DEFAULT_DELIMITER_REGEX));
    }
}