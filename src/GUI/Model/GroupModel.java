package GUI.Model;

import BE.SchoolGroups;
import BLL.GroupManger;
import DAL.db.Teacher.GroupDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class GroupModel {
    GroupDAO groupDAO = new GroupDAO();

    private ObservableList<SchoolGroups> classList = FXCollections.observableArrayList();

    private GroupManger groupManger;

    /**
     * Constructor
     * @throws IOException
     */
    public GroupModel() throws IOException {
        groupManger = new GroupManger();
    }

    /**
     * Gets the list of getAllClasses using the getAllClasses method in classManager.
     * @return a list of getAllClasses
     */
    public ObservableList<SchoolGroups> getAllClasses() {
        classList = groupManger.getAllClasses();
        return classList;
    }

    /**
     * Gets the uploadKlasseInfo className using uploadKlasseInfo from classManger
     * @param className
     * @throws SQLServerException
     */
    public void uploadKlasseInfo(String className) throws SQLException {
        classList.add(groupManger.uploadClassInfo(className));
    }

    /**
     * Gets the deleteAClass selectedGroup using deleteAClass from classManger
     * @param selectedGroup
     */
    public void deleteAGroup(SchoolGroups selectedGroup) {
        classList.remove(selectedGroup);
        groupManger.deleteAGroup(selectedGroup);
    }
}
