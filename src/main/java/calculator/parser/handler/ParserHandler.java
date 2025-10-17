package calculator.parser.handler;

import calculator.exception.ErrorCode;
import calculator.parser.Parser;
import java.util.List;
import java.util.Optional;

public class ParserHandler {

    private final List<Parser> parsers;

    public ParserHandler(Parser defaultDelimiterParser, Parser customDelimiterParser) {
        this.parsers = List.of(defaultDelimiterParser, customDelimiterParser);
    }

    public String[] parse(String input) {
        return parsers.stream()
                .map(parser -> parser.parseInput(input))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.UNSUPPORTED_PARSER_FORMAT.getMessage(input)));
    }
}
