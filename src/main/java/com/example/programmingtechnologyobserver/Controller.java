package com.example.programmingtechnologyobserver;

import ClockComponents.ClockComponent;
import ImageComponent.ImagePane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import observerComponents.TimeServer;
import slideComponent.SlideComponent;

import java.net.URL;

public class Controller implements Initializable {
    @FXML
    public StackPane ImagePane;
    @FXML
    public BorderPane TimerText;
    public StackPane SliderPane;
    private TimeServer timeServer;
    private ClockComponent clockComponent;
    private SlideComponent slideComponent;
    private ImageComponent.ImagePane imageComponentPane;

    @java.lang.Override
    public void initialize(URL url, java.util.ResourceBundle resourceBundle) {
        timeServer = new TimeServer();

        imageComponentPane = new ImagePane();
        clockComponent = new ClockComponent();
        this.slideComponent = new SlideComponent();

        timeServer.attach(imageComponentPane);
        timeServer.attach(this.slideComponent);
        timeServer.attach(clockComponent);

        this.SliderPane.getChildren().add(this.slideComponent.getComponent());
        this.TimerText.setCenter(clockComponent.getClock());
        this.ImagePane.getChildren().add(imageComponentPane.buildMeme());
    }
}