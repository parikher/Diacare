package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiabetesDataDto {

    private Integer userId;
    private Date date;
    private String day;
    private List<ReadingDto> readings = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ReadingDto> getReadings() {
        return readings;
    }

    public void setReadings(List<ReadingDto> readings) {
        this.readings = readings;
    }
}
