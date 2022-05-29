package BLL.Admin;

import BE.Login;
import DAL.db.Admin.AdminDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class AdminManger {

    AdminDAO adminDAO;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public AdminManger() throws IOException {
        adminDAO = new AdminDAO();
    }

    /**
     * Gets the list of getAllAdmins using the getAllTeachers method in adminDAO.
     *
     * @return a list of getAllAdmins
     */
    public ObservableList<Login> getAllAdmins() {
        ObservableList<Login> adminObs = FXCollections.observableArrayList();

        try {
            adminObs.addAll(adminDAO.getAllAdmins());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminObs;
    }
}
