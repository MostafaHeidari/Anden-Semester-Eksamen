package GUI.Model;

import BE.CitizenInfo;
import BLL.CitizenInfoManger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

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
}
