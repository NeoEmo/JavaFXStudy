package org.fxstudy.javafxstudy;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    private static HostServices hostServices;

    @Override
    public void start(Stage stage) throws IOException {
        hostServices = getHostServices();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        InputStream iconStream = getClass().getResourceAsStream("/org/fxstudy/javafxstudy/icon.png");

        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        stage.setTitle("Simple Application");
        stage.setScene(scene);
        stage.show();
        HBox hBox = new HBox();
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        hBox.getChildren().addAll(button1,button2,button3,button4);
    }

    public static HostServices getAppHostServices() {
        return hostServices;
    }
}
