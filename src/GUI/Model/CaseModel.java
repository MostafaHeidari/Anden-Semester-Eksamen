package GUI.Model;

import BE.Case;
import BLL.CaseManger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CaseModel {
    private ObservableList<Case> caseList = FXCollections.observableArrayList();

    private CaseManger caseManger;

    public CaseModel() throws IOException {
        caseManger = new CaseManger();
    }

    public ObservableList<Case> getAllCases(int citizenId) {
        caseList = caseManger.getAllCases(citizenId);
        return caseList;
    }

    public void uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        caseList.add(caseManger.uploadCaseInfo(caseName,informationTxt,selectedCitizen));
    }
}
