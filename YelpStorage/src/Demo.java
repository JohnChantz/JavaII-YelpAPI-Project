import basics.Shop;
import main.Properties;
import main.YelpJsonApi;

import java.util.ArrayList;

public class Demo {
    public static void main(String [] args){
        Properties.InitializeConfigParameters();
        YelpJsonApi yelpJsonApi = new YelpJsonApi();
        ArrayList<Shop> shopList = yelpJsonApi.SearchForShops("san francisco","food");
        for(Shop shop : shopList)
            yelpJsonApi.FetchShop(shop);

        for(Shop shop : shopList)
            System.out.println(shop.toString());
    }
}
