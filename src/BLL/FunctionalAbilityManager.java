package BLL;

import DAL.FunctionalAbilityDAO;
import java.io.IOException;

public class FunctionalAbilityManager {
        FunctionalAbilityDAO functionalAbilityDAO;

        /**
         * Constructor
         * @throws IOException
         */
        public FunctionalAbilityManager() throws IOException {
            functionalAbilityDAO = new FunctionalAbilityDAO();
        }
}
