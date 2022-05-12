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
     * Gets the SchoolClass className using SchoolClass from ClassDAO
     * @param className
     * @return
     * @throws SQLServerException
     */
    public SchoolGroups uploadClassInfo(String className) throws SQLException {
        return (groupDAO.uploadClassInfo(className));
    }

    /**
     * Gets the list of getAllClasses using the getAllClasses method in classDAO.
     * @return a list of getAllClasses
     */
    public ObservableList<SchoolGroups> getAllClasses() {
        ObservableList<SchoolGroups> classesObs = FXCollections.observableArrayList();
        try {
            classesObs.addAll(groupDAO.getAllClasses());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesObs;
    }

    /**
     * Gets the deleteAClass, selectedGroup using deleteAClass from classDAO
     * @param selectedGroup
     */
    public void deleteAGroup(SchoolGroups selectedGroup) {
        groupDAO.deleteAGroup(selectedGroup);
    }
}
