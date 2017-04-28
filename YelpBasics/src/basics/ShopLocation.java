package basics;

import java.io.Serializable;

/*αποθηκευση των πληροφοριων τοποθεσιας για την καθε επιχειρηση*/
public class ShopLocation implements Serializable{

    private String address; //διευθυνση επιχειρησης
    private String city;    //πολυ
    private String state;   //πολιτεια
    private String zip_code;    //ταχυδρομικος κωδικας
    private String country; //χωρα
    private Double latitude;    //γεωγραφικος πλατος
    private Double longtitude;  //γεωγραφικο μηκος

    public ShopLocation() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "ShopLocation{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longtitude + '\'' +
                '}';
    }
}
