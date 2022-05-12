package BLL;

import BE.SchoolGroups;
import DAL.db.Teacher.GroupDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class GroupManger {
    GroupDAO groupDAO = new GroupDAO();

    /**
     * Constructor
     * @throws IOException
     */
    public GroupManger() throws IOException {
    }

    /**
     * Gets the SchoolGroups groupName using SchoolGroups from GroupDAO
     * @param groupName
     * @return
     * @throws SQLServerException
     */
    public SchoolGroups uploadGroupInfo(String groupName) throws SQLException {
        return (groupDAO.uploadGroupInfo(groupName));
    }

    /**
     * Gets the list of getAllGroups using the getAllGroups method in GroupDAO.
     * @return a list of getAllGroups
     */
    public ObservableList<SchoolGroups> getAllGroups() {
        ObservableList<SchoolGroups> classesObs = FXCollections.observableArrayList();
        try {
            classesObs.addAll(groupDAO.getAllGroups());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesObs;
    }

    /**
     * Gets the deleteAGroup, selectedGroup using deleteAGroup from GroupDAO
     * @param selectedGroup
     */
    public void deleteAGroup(SchoolGroups selectedGroup) {
        groupDAO.deleteAGroup(selectedGroup);
    }
}
