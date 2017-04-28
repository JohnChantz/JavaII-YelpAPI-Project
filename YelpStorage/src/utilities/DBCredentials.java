package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBCredentials {

    private static String username;
    private static String password;
    private static String dbUrl;

    private static FileInputStream fileStream = null;
    private static Properties properties = new Properties();

    public DBCredentials() {

    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBCredentials.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBCredentials.password = password;
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl) {
        DBCredentials.dbUrl = dbUrl;
    }

    public static void InitializeCredentials() {
        try {
            fileStream = new FileInputStream("properties/dbcredentials.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found!");
        }
        try {
            properties.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        username = properties.getProperty("dbusername");
        password = properties.getProperty("dbpassword");
        dbUrl = properties.getProperty("database_url");

    }
}
