import basics.Shop;
import storage.DBController;
import utilities.GetShopsFromFile;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        DBController databaseConnection = new DBController();
        databaseConnection.startConnection();

        GetShopsFromFile getShopsFromFile = new GetShopsFromFile();
        ArrayList<Shop> shops = getShopsFromFile.getShop("san francisco");
//        for (Shop shop : shops) {
            System.out.println(shops.get(2).getHours_type());
//        }


//        databaseConnection.addMultipleShops(shops);
//        databaseConnection.addMultipleReviews(shops.get(2).getReviews(),shops.get(2));
        databaseConnection.terminateConnection();

    }
}
