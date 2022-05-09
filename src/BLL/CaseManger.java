package BLL;

import BE.Case;
import DAL.CaseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CaseManger {

    CaseDAO caseDAO;

    public CaseManger() throws IOException {
        caseDAO = new CaseDAO();
    }

    public ObservableList<Case> getAllCases(int citizenId) {
        ObservableList<Case> cases = FXCollections.observableArrayList();

        try {
            cases.addAll(caseDAO.getAllCases(citizenId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cases;
    }

    public Case uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        return(caseDAO.uploadCaseInfo(caseName, informationTxt,selectedCitizen));

    }
}