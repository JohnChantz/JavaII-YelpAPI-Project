package basics;

/*αναπαράσταση των πληροφοριών που παρέχονται στις κριτικές της κάθε επιχείρησης*/
/*κάθε επιχείρηση περιέχει πολλά αντικείμενα τύπου Review σε ένα ArrayList*/
public class Review {

    private String text;    //κειμενο κριτικής
    private String userName;    //ονομα χρήστη που έγραψε την κριτική
    private Long rating;    //βαθμολογία
    private String timeCreated; //χρόνος δημιουργίας της κριτικής

    public Review() {
    }

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
        return "Review{" +
                "text=" + text + " " +
                ", userName=" + userName + " " +
                ", rating=" + rating + " " +
                ", timeCreated=" + timeCreated + " " +
                '}';
    }
}
