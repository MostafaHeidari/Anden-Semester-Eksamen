package BLL;

import BE.Case;
import DAL.CaseDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CaseManger {

    CaseDAO caseDAO;

    public CaseManger() throws IOException {
        caseDAO = new CaseDAO();
    }

    /**
     * Gets the list of getAllCases using the getAllCases method in caseDAO.
     * @return a list of getAllCases
     * @param citizenId
     */
    public ObservableList<Case> getAllCases(int citizenId) {
        ObservableList<Case> cases = FXCollections.observableArrayList();

        try {
            cases.addAll(caseDAO.getAllCases(citizenId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cases;
    }


    /**
     * Gets the uploadCaseInfo caseName, informationTxt, selectedCitizen using uploadCaseInfo from caseDAO
     * @param caseName
     * @param informationTxt
     * @param selectedCitizen
     * @throws SQLServerException
     */
    public Case uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        return(caseDAO.uploadCaseInfo(caseName, informationTxt,selectedCitizen));

    }


    /**
     * Gets the deleteCase selectedCase using deleteCase from caseDAO
     * @param selectedCase
     * @throws SQLServerException
     */
    public void deleteCase(Case selectedCase) {
        caseDAO.deleteCase(selectedCase);
    }

    public Case editCase(Case selectedCase) {
        return caseDAO.editCase(selectedCase);
    }
}
