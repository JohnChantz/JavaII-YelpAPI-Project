package basics;

import java.util.ArrayList;

/*αναπαράσταση των πληροφοριών που παρέχονται για κάθε επιχείρηση*/
public class Shop {

    private String name;    //ονομα επιχειρησης
    private String id;  //id επιχειρησης (η αναζητηση με το YelpAPI γινεται με αυτο)
    private String phone;   //τηλεφωνο επιχειρησης
    private String price;   //νομισμα πληρωμης
    private Double rating;  //βαθμολογια
    private String hours_type;  //ειδος ωραριου λειτουργιας
    private ShopLocation shopLocation;  //αντικειμενο που περιεχει τις πληροφοριες τοποθεσιας για την επιχειρηση
    private ArrayList<OpenHour> workingHours;   //ArrayList με τις ωρες λειτουργιας
    private ArrayList<Review> reviews;  //ArrayList με τις κριτικες
    private ArrayList<String> categories;   //ArrayList με τα διαθεσιμα είδη προϊόντων
    private ArrayList<String> transactions; //ArrayList με τους διαθεσιμους τροπους συναλλαγων

    public Shop() {
    }

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
