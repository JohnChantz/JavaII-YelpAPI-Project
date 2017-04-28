package storage;

import basics.Review;
import basics.Shop;
import basics.ShopLocation;
import utilities.DBCredentials;

import java.sql.*;
import java.util.ArrayList;

public class DBController {

    private String dbUrl;
    private String user;
    private String password;

    private String query;
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public static final String queryforShop = "CREATE TABLE shop(" +
            "name VARCHAR(500) NOT NULL," +
            "id VARCHAR(500) NOT NULL PRIMARY KEY," +
            "phone VARCHAR(200)," +
            "price VARCHAR(100)," +
            "rating BINARY_DOUBLE," +
            "hours_type VARCHAR(100)," +
            "address VARCHAR(500) NOT NULL," +
            "city VARCHAR(100) NOT NULL," +
            "state VARCHAR(100) NOT NULL," +
            "zip_code VARCHAR(100)," +
            "country VARCHAR(100)," +
            "latitude BINARY_DOUBLE," +
            "longtitude BINARY_DOUBLE" +
            ")";
    public static final String queryForReview = "CREATE TABLE review(" +
            "text VARCHAR(1500) UNIQUE," +
            "username VARCHAR(500)," +
            "rating LONG," +
            "timecreated VARCHAR(500)," +
            "shopID VARCHAR(500)," +
            "CONSTRAINT fk_shopID FOREIGN KEY (shopID) REFERENCES SHOP(ID)" +
            ")";

    public DBController() {
        DBCredentials.InitializeCredentials();
        this.dbUrl = DBCredentials.getDbUrl();
        this.user = DBCredentials.getUsername();
        this.password = DBCredentials.getPassword();
    }

    public void startConnection() {
        try {
            connection = DriverManager.getConnection(this.dbUrl, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Connection to oracle database failed!");
            return;
        }
        System.out.println("Connection to oracle database successful!");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to create Statement!");
        }
        System.out.println("Statement created successfully!");

    }

    public void terminateConnection() {
        try {
            this.statement.close();
            this.connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addShop(Shop shop) {
        query = "INSERT INTO shop VALUES(" +
                "'" + shop.getName() + "'," +
                "'" + shop.getId() + "'," +
                "'" + shop.getPhone() + "'," +
                "'" + shop.getPrice() + "'," +
                shop.getRating() + "," +
                "'" + shop.getHours_type() + "'," +
                "'" + shop.getShopLocation().getAddress() + "'," +
                "'" + shop.getShopLocation().getCity() + "'," +
                "'" + shop.getShopLocation().getState() + "'," +
                "'" + shop.getShopLocation().getZip_code() + "'," +
                "'" + shop.getShopLocation().getCountry() + "'," +
                shop.getShopLocation().getLatitude() + "," +
                shop.getShopLocation().getLongtitude() +
                ")";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMultipleShops(ArrayList<Shop> shops) {
        for (Shop shop : shops) {
            query = "INSERT INTO shop VALUES(" +
                    "'" + shop.getName() + "'," +
                    "'" + shop.getId() + "'," +
                    "'" + shop.getPhone() + "'," +
                    "'" + shop.getPrice() + "'," +
                    shop.getRating() + "," +
                    "'" + shop.getHours_type() + "'," +
                    "'" + shop.getShopLocation().getAddress() + "'," +
                    "'" + shop.getShopLocation().getCity() + "'," +
                    "'" + shop.getShopLocation().getState() + "'," +
                    "'" + shop.getShopLocation().getZip_code() + "'," +
                    "'" + shop.getShopLocation().getCountry() + "'," +
                    shop.getShopLocation().getLatitude() + "," +
                    shop.getShopLocation().getLongtitude() +
                    ")";
            try {
                statement.addBatch(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.executeBatch();
    }

    public void executeBatch() {
        try {
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addReview(Review review, Shop shop) {
        query = "INSERT INTO review VALUES(" +
                "'" + review.getText() + "'" +
                "'" + review.getUserName() + "'" +
                "'" + review.getRating() + "'" +
                "'" + review.getTimeCreated() + "'" +
                "'" + shop.getId() + "'" +
                ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMultipleReviews(ArrayList<Review> reviews, Shop shop) {
        for (Review review : reviews) {
            query = "INSERT INTO review VALUES(" +
                    "'" + review.getText() + "'," +
                    "'" + review.getUserName() + "'," +
                    "'" + review.getRating() + "'," +
                    "'" + review.getTimeCreated() + "'," +
                    "'" + shop.getId() + "'" +
                    ")";
            try {
                statement.addBatch(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.executeBatch();
    }

    public ArrayList<Shop> getShops(String city) {
        query = "SELECT * FROM shop WHERE city='" + city + "'";
        ArrayList<Shop> shops = new ArrayList<Shop>();
        try {
            result = statement.executeQuery(query);
            while (result.next()) {
                Shop shop = new Shop();
                shop.setName(result.getString("name"));
                shop.setId(result.getString("id"));
                shop.setPhone(result.getString("phone"));
                shop.setPrice(result.getString("price"));
                shop.setRating(result.getDouble("rating"));
                shop.setHours_type(result.getString("hours_type"));
                ShopLocation location = new ShopLocation();
                location.setAddress(result.getString("address"));
                location.setCity(result.getString("city"));
                location.setState(result.getString("state"));
                location.setZip_code(result.getString("zip_code"));
                location.setCountry(result.getString("country"));
                location.setLatitude(result.getDouble("latitude"));
                location.setLongtitude(result.getDouble("longtitude"));
                shop.setShopLocation(location);
                shops.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public ArrayList<Review> getReviews(String name) {
        query = "SELECT * FROM review where city='" + name + "'";
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            result = statement.executeQuery(query);
            while (result.next()) {
                Review review = new Review();
                review.setText(result.getString("text"));
                review.setUserName(result.getString("username"));
                review.setRating(result.getLong("rating"));
                review.setTimeCreated(result.getString("timecreated"));

                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void createTable(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("Table shop already exists!");
        }
        System.out.println("Table created!");

    }

    public void clearCityRecords(String city) {
        query = "DELETE FROM shop WHERE city ='" + city + "'";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearDatabaseRecords() {
        query = "truncate table shop";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
