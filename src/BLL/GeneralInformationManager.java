package BLL;

import DAL.GeneralInformationDAO;

import java.io.IOException;

public class GeneralInformationManager {

    private GeneralInformationDAO generalInformationDAO;

    public GeneralInformationManager() throws IOException {
        generalInformationDAO = new GeneralInformationDAO();
    }
}
