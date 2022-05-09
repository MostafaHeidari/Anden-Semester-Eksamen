package BLL;

 import DAL.GeneralInformationDAO;

public class GeneralInformationManager {

    private GeneralInformationDAO generalInformationDAO;

    public GeneralInformationManager(GeneralInformationDAO generalInformationDAO) {
        this.generalInformationDAO = generalInformationDAO;
    }

}
