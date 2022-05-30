package GUI.Model;

import BE.CitizenInfo;
import BE.GeneralInformation;
import BLL.GeneralInformationManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class GeneralInformationModel {
    private ObservableList<GeneralInformation> generalInformationList = FXCollections.observableArrayList();

    private final GeneralInformationManager generalInformationManager;

    private CitizenInfo citizenId;

    public GeneralInformationModel() throws IOException {
        generalInformationManager = new GeneralInformationManager();
    }

    public String getAllGeneralInformation(int citizenId) {
        generalInformationList = generalInformationManager.getAllGeneralInformation(citizenId);
        return String.valueOf(generalInformationList);
    }
}
