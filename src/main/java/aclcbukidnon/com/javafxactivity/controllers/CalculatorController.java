package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private Label labelCount;

    private String currentExpression = "";


    @FXML
    private void onButtonClick() {
        Button button = (Button) labelCount.getScene().getFocusOwner();
        String text = button.getText();


        currentExpression += text;


        labelCount.setText(currentExpression);
    }


    @FXML
    private void onEqualsClick() {
        try {

            double result = evaluateExpression(currentExpression);
            labelCount.setText(String.valueOf(result));
            currentExpression = String.valueOf(result);
        } catch (Exception e) {
            labelCount.setText("Error");
            currentExpression = "";
        }
    }


    @FXML
    private void onClearClick() {
        currentExpression = "";
        labelCount.setText("0");
    }


    @FXML
    private void onBackspaceClick() {
        if (!currentExpression.isEmpty()) {
            currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
        }
        labelCount.setText(currentExpression.isEmpty() ? "0" : currentExpression);
    }


    private double evaluateExpression(String expression) throws Exception {


        javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
        return ((Number) engine.eval(expression)).doubleValue();
    }
}

