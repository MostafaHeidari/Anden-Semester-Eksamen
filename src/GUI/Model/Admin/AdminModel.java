package GUI.Model.Admin;

import BE.Admin;
import BE.Login;
import BE.Teacher;
import BLL.Admin.AdminManger;
import BLL.Admin.TeacherManger;
import BLL.LoginManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class AdminModel {

    // Static variable reference of single_instance
    // of type Singleton
    private static AdminModel single_instance = null;


    // Static method
    // Static method to create instance of Singleton class
    public static AdminModel getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new AdminModel();

        return single_instance;
    }

    private LoginManager loginManager;

    private AdminManger adminManger;

    private ObservableList<Login> adminsList = FXCollections.observableArrayList();



    public AdminModel() throws IOException {
        adminManger = new AdminManger();
    }

    /**
     * Gets the list of getAllAdmins using the getAllAdmins method in adminManger.
     * @return a list of getAllAdmins
     */
    public  ObservableList<Login> getAllAdmins() {
        adminsList = adminManger.getAllAdmins();
        return adminsList;
    }
}
