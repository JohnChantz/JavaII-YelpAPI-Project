package utilities;

import basics.Shop;
import main.Properties;
import main.YelpJsonApi;

import java.util.ArrayList;

public class API {
    private YelpJsonApi yelpApi;
    private String location;
    private String term;
    private ArrayList<Shop> shopList;

    public API(String location, String term) {
        Properties.InitializeConfigParameters();
        yelpApi = new YelpJsonApi(location, term);
        this.location = location;
        this.term = term;
    }

    public API() {
        Properties.InitializeConfigParameters();
        yelpApi = new YelpJsonApi();
    }

    public ArrayList<Shop> findShops() {
        this.shopList = yelpApi.SearchForShops(location, term);
        return shopList;
    }

    public ArrayList<Shop> findShops(String location, String term) {
        this.shopList = yelpApi.SearchForShops(location, term);
        for (Shop shop : shopList)
            yelpApi.FetchShop(shop);
        return shopList;
    }

}
