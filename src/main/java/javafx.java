import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;
import java.util.Stack;


public class javafx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Click me!");
        btn.setOnAction(event -> System.out.println("button clicked!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 400,400);
        primaryStage.setTitle("ongodimbouttabust");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
