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

    private static final AppConfig APP_CONFIG_INSTANCE = new AppConfig();

    private AppConfig() {

    }

    public static AppConfig getInstance() {
        return APP_CONFIG_INSTANCE;
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(calculatorService(), inputView(), outputView());
    }

    private CalculatorService calculatorService() {
        return new CalculatorService(stringCalculator(), parserHandler());
    }

    private StringCalculator stringCalculator() {
        return new StringCalculator();
    }

    private ParserHandler parserHandler() {
        return new ParserHandler(defaultDelimiterParser(), customDelimiterParser());
    }

    private Parser defaultDelimiterParser() {
        return new DefaultDelimiterParser();
    }

    private Parser customDelimiterParser() {
        return new CustomDelimiterParser();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
