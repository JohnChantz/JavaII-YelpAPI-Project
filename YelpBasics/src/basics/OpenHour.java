package basics;

/*αναπαριστά τη διαθέσιμη ώρα λειτουργίας για κάθε επιχείρηση*/
/*η κάθε επιχείρηση περιλαμβάνει ένα ArrayList απο πολλά αντικείμενα τύπου OpenHour*/
public class OpenHour {

    private Long day;   //ημερα λειτουργίας
    private String start;   //ώρα ανοίγματος
    private String end; //ώρα κλεισίματος
    private Boolean isOvernight;    //boolean τιμή για το αν είναι ολονύχτια η επιχείρηση

    //Constructor
    public OpenHour(Long day, String from, String to) {
        this.day = day;
        this.start = from;
        this.end = to;
    }

    public OpenHour() {
    }

    //Methods
    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Boolean getIsOvernight() {
        return isOvernight;
    }

    public void setIsOvernight(Boolean isOvernight) {
        this.isOvernight = isOvernight;
    }

    @Override
    public String toString() {
        return "OpenHour{" +
                "day='" + day + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", isOvernight='" + isOvernight + '\'' +
                '}';
    }
}
