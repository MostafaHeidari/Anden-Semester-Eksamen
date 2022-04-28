package DAL.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    private static DatabaseConnector instance = null;
    private static final String PROP_FILE = "config.properties";
    private final SQLServerDataSource dataSource;
    /**
     * Constructor for the database connector.
     */
    public DatabaseConnector() throws IOException
    {
        Properties settings = new Properties();
        settings.load(new FileInputStream(PROP_FILE));

        dataSource = new SQLServerDataSource();
        dataSource.setServerName(settings.getProperty("DatabaseServer"));
        dataSource.setDatabaseName(settings.getProperty("Database"));
        dataSource.setUser(settings.getProperty("Username"));
        dataSource.setPassword(settings.getProperty("Password"));
        dataSource.setTrustServerCertificate(true);
    }

    /**
     * connects to the database using .getConnection();
     */
    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    /**
     * Singleton pattern
     * @return DatabaseConnector called instance
     */
    public static DatabaseConnector getInstance() throws IOException {
        if (instance == null)
            instance = new DatabaseConnector();

        return instance;
    }

    /**
     * Connects the application to our SQL database.
     */
    //Check if there is a connection
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

        try (Connection connection = databaseConnector.getConnection()) {
            System.out.println("Is it open? " + !connection.isClosed());
        }
    }
}
