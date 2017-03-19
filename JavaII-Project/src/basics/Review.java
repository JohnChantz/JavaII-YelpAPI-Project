package basics;

public class Review {

    private String text;
    private String userName;
    private Long rating;
    private String timeCreated;

    //Constructor
    public Review() {
    }

    //Methods
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Review{\n" +
                "text=" + text + "\n" +
                ", userName=" + userName + "\n" +
                ", rating=" + rating + "\n" +
                ", timeCreated=" + timeCreated + "\n" +
                '}';
    }
}
