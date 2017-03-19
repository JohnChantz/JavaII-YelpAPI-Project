package main;

import basics.OpenHour;
import basics.Review;
import basics.Shop;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Properties.InitializeConfigParameters();

        YelpJsonApi yelpJsonApi = new YelpJsonApi();
        ArrayList<Shop> shopsList = yelpJsonApi.SearchForShops();
        for (Shop shop : shopsList) {
            yelpJsonApi.FetchShop(shop);
            yelpJsonApi.GetReviews(shop);
        }
        for (Shop shop : shopsList) {
            System.out.println(shop.toString());
            System.out.println(shop.getCategories());
            if (!shop.getTransactions().isEmpty())
                System.out.println(shop.getTransactions());
            else
                System.out.println("No transactions found!");

            for (Review review : shop.getReviews())
                System.out.println(review.toString());

            ArrayList<OpenHour> arrayList = shop.getWorkingHours();
            if (arrayList != null)
                for (OpenHour openHour : arrayList) {
                    System.out.println(openHour.toString());
                }
            else
                System.out.println("Working Hours not available!");


        }
    }
}
