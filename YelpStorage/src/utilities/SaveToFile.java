package utilities;

import basics.Shop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveToFile {

    private final String path = "records/";
    FileOutputStream fileStream;
    ObjectOutputStream objectStream;


    public SaveToFile() {
    }

    private void openFileStream(String city) {
        try {
            this.fileStream = new FileOutputStream(path + city.toLowerCase() + ".ser");
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file stream!");
            e.printStackTrace();
        }
    }

    private void openObjectStream() {
        try {
            this.objectStream = new ObjectOutputStream(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveShop(ArrayList<Shop> shops) {
        openFileStream(shops.get(1).getShopLocation().getCity());
        openObjectStream();

        try {
            objectStream.writeObject(shops);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileStream != null)
                try {
                    fileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if ((objectStream != null))
                try {
                    objectStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public String getPath() {
        return path;
    }
}
