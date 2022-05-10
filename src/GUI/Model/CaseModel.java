package GUI.Model;

import BE.Case;
import BE.Student;
import BLL.CaseManger;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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

    /**
     * Gets the deleteCase selectedCase using deleteCase from caseManager
     * @param selectedCase
     * @throws SQLServerException
     */
    public void deleteCase(Case selectedCase) {
        caseManger.deleteCase(selectedCase);
        caseList.remove(selectedCase);
    }

    /**
     * Gets the list of getAllCases using the getAllCases method in caseManager.
     * @return a list of getAllCases
     */
    public ObservableList<Case> getAllCases(int citizenId) {
        caseList = caseManger.getAllCases(citizenId);
        return caseList;
    }

    /**
     * Gets the uploadCaseInfo caseName, informationTxt, selectedCitizen using uploadCaseInfo from caseManager
     * @param caseName
     * @param informationTxt
     * @param selectedCitizen
     * @throws SQLServerException
     */
    public void uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        caseList.add(caseManger.uploadCaseInfo(caseName,informationTxt,selectedCitizen));
    }
}
