import basics.Shop;
import storage.DBController;
import storage.FileController;
import utilities.API;
import utilities.RuntimeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        FileController fileController = new FileController();
        DBController dbController = new DBController();
        RuntimeManagement runtimeManagement = new RuntimeManagement();
        API api = new API();
        Scanner scanner = new Scanner(System.in);
        int option;
        ArrayList<Shop> shops = null;
        String city = null, term = null;

        System.out.println("Connecting to database please wait...");
        dbController.startConnection();     //takes a while to connect, that adds a small delay to the application's start up

        System.out.println("*****************");
        System.out.println("***  Welcome  ***");
        System.out.println("*****************");
        System.out.println("Cities available from previous searches:");
        runtimeManagement.printExistingCities();
        System.out.println("----------------------------------------");
        System.out.println("Press:");
        System.out.println("\t\t1)Get information for the cities that already exist in the application files.");
        System.out.println("\t\t2)Get information for cities from the application's database.");
        System.out.println("\t\t3)Get information for cities using YelpApi");
        System.out.println("\t\t4)Clear database records and save the application's record's to the database for the current city.");
        System.out.println("\t\t5)Exit");
        System.out.print("Enter option:");
        option = scanner.nextInt();
        scanner.nextLine();     //sets the cursor to new line where is the user's input

        while (option != 5) {
            if (option < 1 || option > 4) {
                System.out.println("Wrong option!");
            } else {
                System.out.print("Enter City:");
                city = scanner.nextLine();
            }
            switch (option) {
                case (1):
                    shops = fileController.getShops(city);
                    runtimeManagement.printShops(shops);
                    break;
                case (2):
                    shops = dbController.getShops(city);
                    for (Shop shop : shops)
                        shop.setReviews(dbController.getReviews(shop.getId()));
                    runtimeManagement.printShops(shops);
                    break;
                case (3):
                    System.out.print("Enter Term:");
                    term = scanner.next();
                    shops = api.findShops(city, term);
                    runtimeManagement.printShops(shops);
                    break;
                case (4):
                    for (Shop shop : shops)
                        dbController.clearDatabaseRecords(shop);
                    dbController.addMultipleShops(shops);
                    for (Shop shop : shops)
                        dbController.addMultipleReviews(shop.getReviews(), shop.getId());
                    System.out.println("Database refresh successful!");
                    break;
                default:
                    break;
            }
            System.out.print("Enter option:");
            option = scanner.nextInt();
            scanner.nextLine();     //sets the cursor to new line where is the user's input
        }
        scanner.close();
        dbController.terminateConnection();
        System.out.println("Saving application's records...");
        fileController.saveShops(shops);
    }
}

