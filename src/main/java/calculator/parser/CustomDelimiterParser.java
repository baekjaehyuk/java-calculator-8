package calculator.parser;

import static calculator.parser.DefaultDelimiterParser.DEFAULT_DELIMITER_REGEX;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser implements Parser {

    public static final String COMBINED_REGEX = "|";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    @Override
    public Optional<String[]> parseInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            return Optional.empty();
        }

        String customDelimiter = matcher.group(1);
        String numbersPart = matcher.group(2);
        String delimiterRegex = String.join(COMBINED_REGEX, DEFAULT_DELIMITER_REGEX, Pattern.quote(customDelimiter));
        return Optional.of(numbersPart.split(delimiterRegex));
    }
}