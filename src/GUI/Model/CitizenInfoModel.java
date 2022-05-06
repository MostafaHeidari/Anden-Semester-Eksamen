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

    public CitizenInfoModel() throws IOException {
        citizenInfoManger = new CitizenInfoManger();
    }

    public ObservableList getAllCitizens() {
        citizensList = citizenInfoManger.getAllCitizens();
        return citizensList;
    }
}
