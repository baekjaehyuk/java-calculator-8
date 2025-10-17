package calculator.parser;

import java.util.Optional;

public interface Parser {

    Optional<String[]> parseInput(String input);
}
