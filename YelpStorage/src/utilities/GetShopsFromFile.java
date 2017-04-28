package utilities;


import basics.Shop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetShopsFromFile {

    private FileInputStream fileStream;
    private ObjectInputStream objectStream;
    private String city = "los angeles";
    private String path = "records/";
    private ArrayList<Shop> shops = null;

    private void openFileSteam(String city){
        try {
            fileStream = new FileInputStream("records/" + city.toLowerCase() + ".ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void openObjectStream(){
        try {
            objectStream = new ObjectInputStream(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Shop> getShop(String city){
        openFileSteam(city);
        openObjectStream();
        try {
            shops = (ArrayList<Shop>)objectStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileStream != null)
                try {
                    fileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(objectStream != null)
                try {
                    objectStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return shops;
        }
    }
}
