package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label labelCount;  // Label to display the count

    // A variable to hold the current count
    private int count = 0;

    // This method is called when the + button is clicked
    @FXML
    protected void onPlusClick() {
        count++;  // Increment the count by 1
        updateLabel();  // Update the label to display the new count
    }

    // This method is called when the - button is clicked
    @FXML
    protected void onMinusClick() {
        count--;  // Decrement the count by 1
        updateLabel();  // Update the label to display the new count
    }

    // Helper method to update the label with the current count value
    private void updateLabel() {
        labelCount.setText(String.valueOf(count)); // Set the label text to the current count
    }
}
