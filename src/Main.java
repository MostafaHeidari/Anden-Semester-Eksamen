import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/"));
        primaryStage.setTitle("Log in Event Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        StackPane pane = new StackPane();
        //Scene scene = new Scene(pane,100,100);
    }
}