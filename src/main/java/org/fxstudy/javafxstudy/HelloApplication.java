package org.fxstudy.javafxstudy;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class HelloApplication extends Application {
    private static HostServices hostServices;

    @Override
    public void start(Stage stage) throws IOException {
        hostServices = getHostServices();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        InputStream iconStream = getClass().getResourceAsStream("/org/fxstudy/javafxstudy/icon.png");

        Image image = new Image(Objects.requireNonNull(iconStream));
        stage.getIcons().add(image);
        stage.setTitle("Simple Application");
        stage.setScene(scene);
        stage.show();
    }

    public static HostServices getAppHostServices() {
        return hostServices;
    }
}
