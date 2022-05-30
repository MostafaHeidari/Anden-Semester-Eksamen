import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Universal/Login.fxml")));
        primaryStage.setTitle("SOSU System");
        primaryStage.setScene(new Scene(root));
        //primaryStage.setResizable(false);
        primaryStage.show();

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/GUI/View/img/old lady.png")));
        primaryStage.getIcons().add(icon);
    }
}