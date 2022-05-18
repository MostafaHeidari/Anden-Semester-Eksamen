package GUI.Model;

import BE.CitizenInfo;
import BE.Student;
import BLL.CitizenInfoManger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CitizenInfoModel {
    private final CitizenInfoManger citizenInfoManger;
    private ObservableList<CitizenInfo> citizensList = FXCollections.observableArrayList();

    /**
     * Constructor
     * @throws IOException
     */
    public CitizenInfoModel() throws IOException {
        citizenInfoManger = new CitizenInfoManger();
    }

    /**
     * Gets the list of getAllCitizens using the getAllCitizens method in citizenInfoManger.
     * @return a list of getAllCitizens
     */
    public ObservableList getAllCitizens() throws IOException {
        citizensList = citizenInfoManger.getAllCitizens();
        return citizensList;
    }

    /**
     * Creates a case using the createCitizen method from citizenManager
     */



    public void createCitizen(String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) throws SQLException {
        citizensList.add(citizenInfoManger.createCitizen(citizenName, citizenLastName, citizenAddress, CPR,citizenInformation));
    }

    // this method used to edit the Citizen.
    public void editCitizen(CitizenInfo citizenInfo) throws Exception {
        citizenInfoManger.editCitizen(citizenInfo);
        citizensList.clear();
        citizensList.addAll(citizenInfoManger.getAllCitizens());
    }
}
