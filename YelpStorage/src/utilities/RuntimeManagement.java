package utilities;

import basics.Review;
import basics.Shop;
import storage.FileController;

import java.io.File;
import java.util.ArrayList;

//keeps an ArrayList with all shops the user has searched for
//before closure saves the shop object in file for future use
public class RuntimeManagement {

    FileController fileController;

    private final String path = "records/";
    private File directory;
    File[] records;

    public RuntimeManagement() {
    }

    public void printExistingCities() {
        directory = new File(path);
        records = directory.listFiles();
        if (records.length == 0)
            System.out.println("No records from previous usage!");
        else
            for (File record : records) {
                System.out.println("->" + record.getName().substring(0, record.getName().length() - 4));
            }
    }

    public ArrayList<String> returnListOfFiles() {
        ArrayList<String> list = new ArrayList<>();
        directory = new File(path);
        records = directory.listFiles();
        if (records.length == 0)
            return null;
        else
            for (File record : records) {
                list.add(record.getName());
            }
        return list;
    }

    public void printShops(ArrayList<Shop> shops) {
        for (Shop shop : shops) {
            System.out.println(shop.toString());
            for (Review review : shop.getReviews())
                System.out.println(review.toString());
        }
    }
}
