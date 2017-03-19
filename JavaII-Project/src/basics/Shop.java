package basics;

import java.util.ArrayList;

public class Shop {

    private String name;
    private String id;
    private String phone;
    private String price;
    private Double rating;
    private String hours_type;
    private ShopLocation shopLocation;
    private ArrayList<OpenHour> workingHours;
    private ArrayList<Review> reviews;
    private ArrayList<String> categories;
    private ArrayList<String> transactions;

    //Constructor
    public Shop() {
    }

    //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ShopLocation getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(ShopLocation shopLocation) {
        this.shopLocation = shopLocation;
    }

    public ArrayList<OpenHour> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(ArrayList<OpenHour> workingHours) {
        this.workingHours = workingHours;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void clearReviews() {
        reviews.clear();
    }

    public void printAllReviews() {
        for (int i = 0; i < reviews.size(); i++) {
            reviews.get(i).toString();
        }
    }

    public String getHours_type() {
        return hours_type;
    }

    public void setHours_type(String hours_type) {
        this.hours_type = hours_type;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +
                ", hours_type=" + hours_type + '\'' +
                ", shopLocation=" + shopLocation.toString() +
                '}';
    }
}
