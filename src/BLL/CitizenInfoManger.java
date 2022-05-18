package BLL;

import BE.CitizenInfo;
import DAL.CitizenInfoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CitizenInfoManger {
    private CitizenInfoDAO citizenInfoDAO;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public CitizenInfoManger() throws IOException {
        citizenInfoDAO = new CitizenInfoDAO();
    }

    /**
     * Gets the list of getAllCitizens using the getAllCitizens method in citizenInfoDAO.
     *
     * @return a list of getAllClasses
     */
    public ObservableList<CitizenInfo> getAllCitizens() {
        ObservableList<CitizenInfo> citizensObs = FXCollections.observableArrayList();

        try {
            citizensObs.addAll(citizenInfoDAO.getAllCitizens());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizensObs;
    }


    /**
     * Creates a case using the createCitizen method from citizenDAO
     */

    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) throws SQLException {
        return (citizenInfoDAO.createCitizen(citizenName, citizenLastName, citizenAddress, CPR, citizenInformation));
    }

    // edit Citizen method
    public void editCitizen(CitizenInfo CitizenInfo) throws Exception {
        citizenInfoDAO.editCitizen(CitizenInfo);
    }
}
