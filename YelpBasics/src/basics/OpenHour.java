package basics;

public class OpenHour {

    private Long day;
    private String start;
    private String end;
    private Boolean isOvernight;

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
