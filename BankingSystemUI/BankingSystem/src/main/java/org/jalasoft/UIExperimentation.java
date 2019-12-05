package org.jalasoft;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class UIExperimentation extends Application {

    @Override

    public void start(Stage primaryStage)throws Exception{
        //Stage (The screen) configuration

        primaryStage.setTitle("Bank Application");
        //primaryStage.setWidth(640);
        //primaryStage.setHeight(480);
        // primaryStage.show();
        
        //Create your components
        Label helloWorldLabel= new  Label("Hello world");

        Button helloWorldButton = new Button ("Press me !");
        //Arrahge your components inside some layout
        GridPane gridPane = new GridPane();
       gridPane.setPadding(new Insets(40,80, 40,80));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        gridPane.add(helloWorldLabel, 0, 0);
        gridPane.add(helloWorldButton, 1, 0);

        //HBox box = new HBox(helloWorldLabel, helloWorldButton);

        //Given behaviors to your components
        helloWorldButton.setOnAction(handle -> {
            helloWorldLabel.setText("Something else!!");
        });


        //Final Configuration
        Scene scene = new  Scene (gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}