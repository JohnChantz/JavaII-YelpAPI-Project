package main;

import basics.OpenHour;
import basics.Review;
import basics.Shop;
import basics.ShopLocation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class YelpJsonApi {

    private final String USER_AGENT = "Mozilla/5.0";
    private String term = "food";    //to be user input in GUI
    private String location = "san francisco";    //to be user input in GUI
    private final String header_key = Properties.getKey();
    private final String header_value = Properties.getValue();
    private Document doc = null;
    JSONObject jsonObject = null;
    String url;

    //Constructor
    public YelpJsonApi() {
    }

    private JSONObject connectToApi(String url) {

        jsonObject = null;
        String responseText;
        JSONParser parser = new JSONParser();
        try {
            doc = Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .header(header_key, header_value)
                    .ignoreContentType(true)
                    .get();

            responseText = doc.text();
            jsonObject = (JSONObject) parser.parse(responseText);
//            System.out.println(jsonObject);
        } catch (IOException | ParseException e1) {
            e1.printStackTrace();
        }
        return jsonObject;
    }

    public ArrayList SearchForShops(/*String location,String term*/) {
        url = Properties.getBusiness_search() + "term=" + term + "&location=" + location;
        ArrayList<Shop> shopList = null;

        jsonObject = connectToApi(url);
        JSONArray businessList = (JSONArray) jsonObject.get("businesses");

        shopList = new ArrayList<>();
        for (int i = 0; i < businessList.size(); i++) {
            JSONObject jsonShop = (JSONObject) businessList.get(i);
            String shopId = (String) jsonShop.get("id");
            Shop newShop = new Shop();
            newShop.setId(shopId);
            shopList.add(newShop);
        }
        int counter = 1;
        for (Shop x : shopList) {
            System.out.println(counter++ + ")" + x.getId());
        }
        return shopList;
    }

    public void FetchShop(Shop shop) {
        String url = Properties.getBusiness_details() + shop.getId();
        jsonObject = connectToApi(url);

        //get shop basic info
        shop.setName((String) jsonObject.get("name"));
        shop.setPhone((String) jsonObject.get("display_phone"));
        shop.setPrice((String) jsonObject.get("price"));
        shop.setRating((Double) jsonObject.get("rating"));

        //get shop working hours
        JSONArray jsonHours = (JSONArray) jsonObject.get("hours");
        ArrayList<OpenHour> openHoursList = new ArrayList<>();
        if (jsonHours == null) {
            openHoursList = null;   //if working hours are not available
        } else {
            JSONObject tempObj = (JSONObject) jsonHours.get(0);
            shop.setHours_type((String) tempObj.get("hours_type"));
            JSONArray jsonOpenHoursList = (JSONArray) tempObj.get("open");
            for (int i = 0; i < jsonOpenHoursList.size(); i++) {
                //create new openHours obj for each json obj
                OpenHour newOpenHour = new OpenHour();
                JSONObject jsonHour = (JSONObject) jsonOpenHoursList.get(i);
                newOpenHour.setDay((Long) jsonHour.get("day"));
                newOpenHour.setStart((String) jsonHour.get("start"));
                newOpenHour.setEnd((String) jsonHour.get("end"));
                newOpenHour.setIsOvernight((Boolean) jsonHour.get("is_overnight"));
                openHoursList.add(newOpenHour);
            }
        }
        shop.setWorkingHours(openHoursList);

        //get shop categories eg. cofes,tea etc
        JSONArray jsonCategories = (JSONArray) jsonObject.get("categories");
        ArrayList<String> categoriesList = new ArrayList<>();
        for (int i = 0; i < jsonCategories.size(); i++) {
            JSONObject jsonCategory = (JSONObject) jsonCategories.get(i);
            categoriesList.add((String) jsonCategory.get("title"));
        }
        shop.setCategories(categoriesList);

        //get shop location info
        JSONObject jsonLocation = (JSONObject) jsonObject.get("location");
        ShopLocation shopLocation = new ShopLocation();
        shopLocation.setAddress((String) jsonLocation.get("address1"));
        shopLocation.setCity((String) jsonLocation.get("city"));
        shopLocation.setCountry((String) jsonLocation.get("county"));
        shopLocation.setState((String) jsonLocation.get("state"));
        shopLocation.setZip_code((String) jsonLocation.get("zip_code"));
        shop.setShopLocation(shopLocation);

        //get shop coordinates
        JSONObject jsonCoordinates = (JSONObject) jsonObject.get("coordinates");
        shopLocation.setLatitude((Double) jsonCoordinates.get("latitude"));
        shopLocation.setLongtitude((Double) jsonCoordinates.get("longitude"));

        //get shop transactions
        JSONArray jsonTransactions = (JSONArray) jsonObject.get("transactions");
        ArrayList<String> transactionsList = new ArrayList<>();
        for (int i = 0; i < jsonTransactions.size(); i++) {
            transactionsList.add((String) jsonTransactions.get(i));
        }
        shop.setTransactions(transactionsList);
    }

    public void GetReviews(Shop shop) {
        url = Properties.getBusiness_reviews() + shop.getId() + "/reviews";
        jsonObject = connectToApi(url);

        JSONArray jsonReviewArray = (JSONArray) jsonObject.get("reviews");
        ArrayList<Review> reviewArrayList = new ArrayList<>();
        for (int i = 0; i < jsonReviewArray.size(); i++) {
            Review shopReview = new Review();
            JSONObject jsonReviewObj = (JSONObject) jsonReviewArray.get(i);
            shopReview.setText((String) jsonReviewObj.get("text"));
            JSONObject jsonUserObj = (JSONObject) jsonReviewObj.get("user");
            shopReview.setUserName((String) jsonUserObj.get("name"));
            shopReview.setRating((Long) jsonReviewObj.get("rating"));
            shopReview.setTimeCreated((String) jsonReviewObj.get("time_created"));
            reviewArrayList.add(shopReview);
        }
        shop.setReviews(reviewArrayList);
    }
}

