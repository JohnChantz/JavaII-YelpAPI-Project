package utilities;

import basics.Shop;
import main.Properties;
import main.YelpJsonApi;

import java.util.ArrayList;

public class GetShopsFromAPI {
    YelpJsonApi api;
    private String location;
    private String term;
    ArrayList<Shop> shopList;

    public GetShopsFromAPI(String location, String term) {
        Properties.InitializeConfigParameters();
        api = new YelpJsonApi(location, term);
        this.location = location;
        this.term = term;
    }

    public GetShopsFromAPI() {
        Properties.InitializeConfigParameters();
    }

    public ArrayList<Shop> findShops() {
        this.shopList = api.SearchForShops(location, term);
        return shopList;
    }

}
