package main;

import basics.OpenHour;
import basics.Review;
import basics.Shop;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Properties.InitializeConfigParameters();

        YelpJsonApi yelpJsonApi = new YelpJsonApi();
        ArrayList<Shop> shopsList = yelpJsonApi.SearchForShops("san francisco", "food");
        for (Shop shop : shopsList) {
            yelpJsonApi.FetchShop(shop);
        }
        for (Shop shop : shopsList) {
            System.out.println(shop.toString());
            if (!shop.getCategories().isEmpty())
                System.out.println(shop.getCategories());
            else
                System.out.println("No categories found!");

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
        System.out.println("***********************************************************");

        ArrayList<Shop> openShops = yelpJsonApi.GetOpenShopsForSpecificHour("san francisco", "food", 1100, 2200);
        for (Shop shop : openShops)
            System.out.println(shop.getName());
    }
}
