package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Properties {
    //Online shop search parameters

    //Yelp API urls
    private static String business_search;  //https://api.yelp.com/v3/businesses/search?
    private static String business_details; //https://api.yelp.com/v3/businesses/
    private static String business_reviews; //https://api.yelp.com/v3/businesses/{id}/reviews

    //Yelp API parameters (DO NOT CHANGE THEM)
    private static String token_type;
    private static String access_token;

    //API call headers
    private static String key;
    private static String value;

    //DB credentials
    private static String dbuser;
    private static String dbpassword;
    private static String database;

    private static java.util.Properties prop = new java.util.Properties();
    private static InputStream inputStream = null;

    public Properties() {
    }

    public static String getBusiness_search() {
        return business_search;
    }

    public static void setBusiness_search(String business_search) {
        Properties.business_search = business_search;
    }

    public static String getBusiness_details() {
        return business_details;
    }

    public static void setBusiness_details(String business_details) {
        Properties.business_details = business_details;
    }

    public static String getBusiness_reviews() {
        return business_reviews;
    }

    public static void setBusiness_reviews(String business_reviews) {
        Properties.business_reviews = business_reviews;
    }

    public static String getToken_type() {
        return token_type;
    }

    public static void setToken_type(String token_type) {
        Properties.token_type = token_type;
    }

    public static String getAccess_token() {
        return access_token;
    }

    public static void setAccess_token(String access_token) {
        Properties.access_token = access_token;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Properties.key = key;
    }

    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        Properties.value = value;
    }

    public static String getDbuser() {
        return dbuser;
    }

    public static void setDbuser(String dbuser) {
        Properties.dbuser = dbuser;
    }

    public static String getDbpassword() {
        return dbpassword;
    }

    public static void setDbpassword(String dbpassword) {
        Properties.dbpassword = dbpassword;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        Properties.database = database;
    }

    public static java.util.Properties getProp() {
        return prop;
    }

    public static void setProp(java.util.Properties prop) {
        Properties.prop = prop;
    }

    public static InputStream getInputStream() {
        return inputStream;
    }

    public static void setInputStream(InputStream inputStream) {
        Properties.inputStream = inputStream;
    }

    public static void InitializeConfigParameters() {
        try {
            inputStream = new FileInputStream("properties\\config.properties");
            prop.load(inputStream);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        business_search = prop.getProperty("business_search");
        business_details = prop.getProperty("business_details");
        business_reviews = prop.getProperty("business_reviews");

        token_type = prop.getProperty("token_type");
        access_token = prop.getProperty("access_token");

        key = prop.getProperty("key");
        value = prop.getProperty("value");

        dbuser = prop.getProperty("dbuser");
        dbpassword = prop.getProperty("dbpassword");
        database = prop.getProperty("database");
    }
}
