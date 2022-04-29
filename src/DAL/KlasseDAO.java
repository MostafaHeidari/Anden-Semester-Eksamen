package DAL;

import BE.Klasse;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlasseDAO {

    private DatabaseConnector DC;

    public KlasseDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public Klasse uploadKlasseInfo(String klasseNavn) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO ClassTable(ClassName,Class) VALUES (?,?);";
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

    public List<Klasse> getAllKlasser() throws SQLException {
        Connection con = DC.getConnection();

        List<Klasse>  allKlasser= new ArrayList<>();


        String sql = "SELECT * FROM ClassTable WHERE Class = 'klasse'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds Klasser objects into an array list
            Klasse klasseCord = new Klasse(rs.getInt("ClassID"), rs.getString("ClassName"));
            allKlasser.add(klasseCord);
        }
        return allKlasser;
    }
}
