package calculator.service;

import calculator.model.StringCalculator;
import calculator.parser.handler.ParserHandler;

public class CalculatorService {

    private final StringCalculator stringCalculator;
    private final ParserHandler parserHandler;

    public CalculatorService(StringCalculator stringCalculator, ParserHandler parserHandler) {
        this.stringCalculator = stringCalculator;
        this.parserHandler = parserHandler;
    }

    public int calculate(String input) {
        if (input.isBlank()) {
            return stringCalculator.getEmptyResult();
        }
        String[] numbers = parserHandler.parse(input);
        return stringCalculator.sum(numbers);
    }
}

