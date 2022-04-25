package DAL.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseConnector {
    private static final String PROP_FILE = "config.properties";
    private SQLServerDataSource dataSoruce;
    /**
     * Constructor for the database connector.
     */
    public DatabaseConnector() throws IOException
    {
        Properties settings = new Properties();
        settings.load(new FileInputStream(PROP_FILE));

        dataSoruce = new SQLServerDataSource();
        dataSoruce.setServerName(settings.getProperty("DatabaseServer"));
        dataSoruce.setDatabaseName(settings.getProperty("Database"));
        dataSoruce.setUser(settings.getProperty("Username"));
        dataSoruce.setPassword(settings.getProperty("Password"));
        dataSoruce.setTrustServerCertificate(true);
    }

    /**
     * Connects the application to our SQL database.
     */
    public Connection getConnection() throws SQLServerException
    {
        return dataSoruce.getConnection();
    }
}
