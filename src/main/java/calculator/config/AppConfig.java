package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.parser.CustomDelimiterParser;
import calculator.parser.DefaultDelimiterParser;
import calculator.parser.Parser;
import calculator.parser.handler.ParserHandler;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculatorService(), inputView(), outputView());
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(stringCalculator(), parserHandler());
    }

    public StringCalculator stringCalculator() {
        return new StringCalculator();
    }

    public ParserHandler parserHandler() {
        return new ParserHandler(defaultDelimiterParser(), customDelimiterParser());
    }

    public Parser defaultDelimiterParser() {
        return new DefaultDelimiterParser();
    }

    public Parser customDelimiterParser() {
        return new CustomDelimiterParser();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
