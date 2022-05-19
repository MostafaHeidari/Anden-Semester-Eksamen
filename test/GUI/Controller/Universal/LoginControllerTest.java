package GUI.Controller.Universal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LoginControllerTest {

    @Test
    void login() throws IOException {
        //Triple A pattern

        //Arrange - setup our test objects etc.
        LoginController Login = new LoginController();

        // Act - do the actual calc or method run
        //Student
        boolean actualValue = Login.equals("Student");

    }

    @Test
    void handleOnKeyPressed() {
    }
}