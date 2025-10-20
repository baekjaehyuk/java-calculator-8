package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        CalculatorController calculatorController = appConfig.calculatorController();
        calculatorController.run();
    }
}
