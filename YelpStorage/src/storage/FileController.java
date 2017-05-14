package storage;


import basics.Shop;

import java.io.*;
import java.util.ArrayList;

public class FileController {

    private FileInputStream fileInput;
    private FileOutputStream fileOutput;
    private ObjectInputStream objectInput;
    private ObjectOutputStream objectOutput;
    private String city = "los angeles";
    private String path = "records/";
    private ArrayList<Shop> shops = null;

    public FileController() {
    }

    private void openFileInputStream(String city) {
        try {
            this.fileInput = new FileInputStream("records/" + city + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void openObjectInputStream() {
        try {
            this.objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openFileOutputStream(String city) {
        try {
            this.fileOutput = new FileOutputStream(path + city + ".txt");
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file stream!");
            e.printStackTrace();
        }
    }

    private void openObjectOutputStream() {
        try {
            this.objectOutput = new ObjectOutputStream(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Shop> getShops(String city) {
        openFileInputStream(city);
        openObjectInputStream();
        try {
            shops = (ArrayList<Shop>) objectInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null)
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (objectInput != null)
                try {
                    objectInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return shops;
        }
    }

    public void saveShops(ArrayList<Shop> shops) {
        openFileOutputStream(shops.get(1).getShopLocation().getCity());
        openObjectOutputStream();

        try {
            objectOutput.writeObject(shops);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutput != null)
                try {
                    fileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if ((objectOutput != null))
                try {
                    objectOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
