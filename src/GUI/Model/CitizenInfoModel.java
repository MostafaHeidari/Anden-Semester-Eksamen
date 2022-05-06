package GUI.Model;

import BE.Citizen;
import BE.Student;
import BLL.CitizenInfoManger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class CitizenInfoModel {
    private CitizenInfoManger citizenInfoManger;
    private ObservableList<Citizen> citizensList = FXCollections.observableArrayList();

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
}
