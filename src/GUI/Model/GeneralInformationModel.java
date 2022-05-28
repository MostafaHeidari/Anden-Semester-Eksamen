package GUI.Model;

import BLL.GeneralInformationManager;
import DAL.GeneralInformationDAO;

import java.io.IOException;

public class GeneralInformationModel {

    GeneralInformationDAO generalInformationDAO = new GeneralInformationDAO();
    private GeneralInformationManager generalInformationManager;

    /**
     * Constructor
     * @throws IOException
     */
    public GeneralInformationModel() throws IOException {
        generalInformationManager = new GeneralInformationManager();
    }
}
