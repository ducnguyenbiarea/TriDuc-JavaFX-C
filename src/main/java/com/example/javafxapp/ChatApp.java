package com.example.javafxapp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 600);
        scene.setFill(Color.WHITE);
        primaryStage.setTitle("Chat App");
        primaryStage.setScene(scene);
        primaryStage.show();

        VBox messages = new VBox();
        messages.setStyle("-fx-background-color: white;");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.prefWidthProperty().bind(root.widthProperty());
        scrollPane.setStyle("-fx-background-color: white;");
        scrollPane.setContent(messages);
        messages.setPrefWidth(498);
        messages.setPrefHeight(498);
        root.getChildren().add(scrollPane);


        HBox layout = new HBox();
        layout.setStyle("-fx-background-color: blue;");
        layout.setPrefHeight(100);
        layout.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(layout);


        TextField input = new TextField();
        input.setPrefWidth(400);
        input.setPrefHeight(50);
        layout.getChildren().add(input);
        Button submit = new Button("Gửi");
        submit.setPrefWidth(100);
        submit.setPrefHeight(50);
        layout.getChildren().add(submit);

        EventHandler<MouseEvent> submitClicked = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                HBox messageBox = new HBox();
                //messageBox.setPadding(new Insets(20, 20, 20, 20));
                messageBox.setAlignment(Pos.CENTER_LEFT);
                Label message = new Label(input.getText());
                message.setPadding(new Insets(5));
                message.setStyle("-fx-background-color: #add8e6;");
                message.setPrefHeight(20);
                messages.getChildren().add(message);

                HBox replyBox = new HBox();
                replyBox.setAlignment(Pos.CENTER_RIGHT);
                Label reply = new Label("I dont understand");
                reply.setPadding(new Insets(5));
                reply.setStyle("-fx-background-color: #add8e6;");
                reply.setPrefHeight(20);
                replyBox.getChildren().add(reply);
                messages.getChildren().add(replyBox);
            }
        };
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, submitClicked);
    }
    public static void main(String args[]) {
        launch(args);
    }
}