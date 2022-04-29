package DAL;

import BE.Klasse;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class KlasseDAO {

    private DatabaseConnector DC;

    public KlasseDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public Klasse uploadKlasseInfo(String klasseNavn) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO ClassTable (ClassNavn,Class) VALUES (?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, klasseNavn);;
        ps.setString(2, "klasse");
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int klasseId = rs.getInt(1);
                Klasse klasseCord = new Klasse(klasseId, klasseNavn);
                return klasseCord;
            }

        }
        return null;
    }
}
