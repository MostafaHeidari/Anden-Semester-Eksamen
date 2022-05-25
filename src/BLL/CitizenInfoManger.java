package BLL;

import BE.CitizenInfo;
import DAL.CitizenInfoDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CitizenInfoManger {
    private final CitizenInfoDAO citizenInfoDAO;

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

    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String Age) throws SQLException {
        return (citizenInfoDAO.createCitizen(citizenName, citizenLastName, Age));
    }

    /**
     * Gets the editCitizen student using editCitizen from studentDAO
     * @param CitizenInfo
     * @throws SQLServerException
     */
    public void editCitizen(CitizenInfo CitizenInfo) throws Exception {
        citizenInfoDAO.editCitizen(CitizenInfo);
    }


    /**
     * Gets the removeCitizen selectedCitizen using removeCitizen from citizenInfoDAO
     * @param selectedCitizen
     * @throws SQLServerException
     */
    public void removeCitizen(CitizenInfo selectedCitizen) {
        citizenInfoDAO.removeCitizen(selectedCitizen);
    }
}
