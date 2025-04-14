package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label display;

    private StringBuilder input = new StringBuilder();
    private String operator = "";
    private double firstOperand = 0;

    @FXML
    private void initialize() {
        display.setText("0");
    }

    @FXML
    private void handleButtonPress(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        switch (value) {
            case "CLEAR" -> {
                input.setLength(0);
                operator = "";
                firstOperand = 0;
                display.setText("0");
            }
            case "BCKSPC" -> {
                if (input.length() > 0) {
                    input.setLength(input.length() - 1);
                    display.setText(input.length() == 0 ? "0" : input.toString());
                }
            }
            case "+", "-", "*", "/" -> {
                if (input.length() > 0) {
                    firstOperand = Double.parseDouble(input.toString());
                    operator = value;
                    input.setLength(0);
                    display.setText("0");
                }
            }
            case "=" -> {
                if (input.length() > 0 && !operator.isEmpty()) {
                    double secondOperand = Double.parseDouble(input.toString());
                    double result = calculate(firstOperand, secondOperand, operator);
                    display.setText(String.valueOf(result));
                    input.setLength(0);
                    input.append(result);
                    operator = "";
                }
            }
            case "." -> {
                if (!input.toString().contains(".")) {
                    input.append(".");
                    display.setText(input.toString());
                }
            }
            default -> {
                input.append(value);
                display.setText(input.toString());
            }
        }
    }

    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b != 0 ? a / b : 0;
            default -> 0;
        };
    }
}
