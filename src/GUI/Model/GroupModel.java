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

    private final GroupManger groupManger;

    /**
     * Constructor
     * @throws IOException
     */
    public GroupModel() throws IOException {
        groupManger = new GroupManger();
    }

    /**
     * Gets the list of getAllGroups using the getAllGroups method in GroupManger.
     * @return a list of getAllGroups
     */
    public ObservableList<SchoolGroups> getAllGroups() {
        classList = groupManger.getAllGroups();
        return classList;
    }

    /**
     * Gets the uploadGroupInfo groupName using uploadGroupInfo from GroupManger
     * @param groupName
     * @throws SQLServerException
     */
    public void uploadGroupInfo(String groupName) throws SQLException {
        classList.add(groupManger.uploadGroupInfo(groupName));
    }

    /**
     * Gets the deleteAGroup selectedGroup using deleteAGroup from GroupManger
     * @param selectedGroup
     */
    public void deleteAGroup(SchoolGroups selectedGroup) {
        classList.remove(selectedGroup);
        groupManger.deleteAGroup(selectedGroup);
    }
}
