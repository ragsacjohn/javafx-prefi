package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        GO,
        HOLD
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;
    private Timeline timeline;

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    public void initialize() {
        updateLights();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void onTimerChange() {
        switch (currentColor) {
            case STOP -> currentColor = TrafficLightColor.GO;
            case GO -> currentColor = TrafficLightColor.HOLD;
            case HOLD -> currentColor = TrafficLightColor.STOP;
        }
        updateLights();
    }

    private void updateLights() {
        redLight.setFill(currentColor == TrafficLightColor.STOP ? Color.RED : Color.DARKRED);
        yellowLight.setFill(currentColor == TrafficLightColor.HOLD ? Color.YELLOW : Color.GOLDENROD);
        greenLight.setFill(currentColor == TrafficLightColor.GO ? Color.LIMEGREEN : Color.DARKGREEN);
    }

    @FXML
    private void startSimulation() {
        timeline.play();
    }

    @FXML
    private void stopSimulation() {
        timeline.stop();
    }
}
