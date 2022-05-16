import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MostafaTestView extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
            primaryStage.setTitle("SOSU System");
            primaryStage.setScene(new Scene(root));
            //primaryStage.setResizable(false);
            primaryStage.show();
        }
}
