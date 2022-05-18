package GUI.Controller.Universal.Case;

import BE.Case;
import BE.CitizenInfo;
import BE.Student;
import GUI.Model.CaseModel;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CasesEditController {

    private final CaseModel caseModel = new CaseModel();

    Case selectedCase;

    private CasesController mainController;

    int selectedCitizenInfo;

    public TextField caseNameTxt;
    public TextField InformationTxt;
    public JFXButton saveCase;
    public JFXButton LogOut;
    public JFXButton backTo;

    public CasesEditController() throws IOException {
    }

    public void saveCaseBtn(ActionEvent event) {
        String updateCaseName = caseNameTxt.getText();
        String updateCaseEfterNavn = InformationTxt.getText();


        this.selectedCase.setCaseName(updateCaseName);
        this.selectedCase.setCaseInformation(updateCaseEfterNavn);



        caseModel.editCase(this.selectedCase);
        mainController.tvCase.refresh();

        /*turn back to Create student window*/
        Stage switcher = (Stage) saveCase.getScene().getWindow();
        switcher.setTitle("Case System");
        switcher.close();
    }

    public void LogOutAction(ActionEvent event) {
    }

    public void backToPatientsBtn(ActionEvent event) {
    }

    /**
     * Set selected Case
     * @param cases
     */
    public void setSelectedCase(Case cases) {

        caseNameTxt.setText(cases.getCaseName());

        InformationTxt.setText(cases.getCaseInformation());


        this.selectedCase = cases;
    }

    public void setSelectedCase(int selectedCitizenInfo) {
        this.selectedCitizenInfo = selectedCitizenInfo;
    }


    public void setController(CasesController casesController) {
        mainController = casesController;
    }


}
