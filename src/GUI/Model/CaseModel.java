package GUI.Model;

import BE.Case;
import BE.CitizenInfo;
import BLL.CaseManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CaseModel {
    private ObservableList<Case> caseList = FXCollections.observableArrayList();

    private final CaseManager caseManger;

    private CitizenInfo citizenId;

    public CaseModel() throws IOException {
        caseManger = new CaseManager();
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

    /**
     * Gets the editStudent student using editStudent from studentManager
     * @param selectedCase
     * @throws SQLServerException
     */
    public void editCase(Case selectedCase) {
        caseManger.editCase(selectedCase);
    }
}
