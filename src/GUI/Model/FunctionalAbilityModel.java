package GUI.Model;

import BE.FunctionalAbility;
import BLL.FunctionalAbilityManager;
import DAL.FunctionalAbilityDAO;

import java.io.IOException;

public class FunctionalAbilityModel {

    FunctionalAbilityDAO functionalAbilityDAO = new FunctionalAbilityDAO();
    private FunctionalAbilityManager functionalAbilityManager;

    public FunctionalAbilityModel() throws IOException {
        functionalAbilityManager = new FunctionalAbilityManager();
    }
}
