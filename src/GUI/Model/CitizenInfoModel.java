package GUI.Model;

import BE.CitizenInfo;
import BLL.CitizenInfoManger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CitizenInfoModel {
    private CitizenInfoManger citizenInfoManger;
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
    public ObservableList getAllCitizens() {
        citizensList = citizenInfoManger.getAllCitizens();
        return citizensList;
    }

    /**
     * Creates a case using the createCitizen method from citizenManager
     */

    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) throws SQLException {
        return citizenInfoManger.createCitizen(citizenName, citizenLastName, citizenAddress, CPR,citizenInformation);
    }
}
