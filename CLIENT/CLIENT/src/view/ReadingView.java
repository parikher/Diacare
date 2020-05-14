package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ReadingDetailsDto;
import service.ReadingService;
import util.Utilities;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean
@ViewScoped
public class ReadingView implements Serializable {

    private Integer userId;
    private String date;
    private String day;
    private String insulinBeforeBed;
    private String insulinBeforeBedTime;
    private String sugarAtFast;
    private String sugarAtFastTime;
    private String mrngInsulinBeforeFood;
    private String mrngInsulinBeforeFoodTime;
    private String mrngInsulinAfterFood;
    private String mrngInsulinAfterFoodTime;
    private String mrngPlace;
    private String mrngSugarBeforeFood;
    private String mrngSugarBeforeFoodTime;
    private String mrngSugarAfterFood;
    private String mrngSugarAfterFoodTime;
    private String noonInsulinBeforeFood;
    private String noonInsulinBeforeFoodTime;
    private String noonInsulinAfterFood;
    private String noonInsulinAfterFoodTime;
    private String noonPlace;
    private String noonSugarBeforeFood;
    private String noonSugarBeforeFoodTime;
    private String noonSugarAfterFood;
    private String noonSugarAfterFoodTime;
    private String evngInsulinBeforeFood;
    private String evngInsulinBeforeFoodTime;
    private String evngInsulinAfterFood;
    private String evngInsulinAfterFoodTime;
    private String evngPlace;
    private String evngSugarBeforeFood;
    private String evngSugarBeforeFoodTime;
    private String evngSugarAfterFood;
    private String evngSugarAfterFoodTime;
    private String comment;

    private static Boolean isSave;

    @ManagedProperty(value="#{readingService}")
    private ReadingService service;

    public void setService(ReadingService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/readings/todaysReading")
                .queryParam("userId", Utilities.getUserId());
        Invocation.Builder invocationBuilder = target.request();
        Response response = invocationBuilder.get();
        ReadingDetailsDto readingDetailsDto = response.readEntity(new GenericType<ReadingDetailsDto>() {});
        if(readingDetailsDto != null){
            this.setIsSave(Boolean.FALSE);
            this.date = readingDetailsDto.getDate();
            this.day = readingDetailsDto.getDay();

            if(readingDetailsDto.getInsulinBeforeBed()!=null) {
                this.insulinBeforeBed = String.valueOf(readingDetailsDto.getInsulinBeforeBed());
            }
            if(readingDetailsDto.getInsulinBeforeBedTime()!=null) {
                this.insulinBeforeBedTime = readingDetailsDto.getInsulinBeforeBedTime();
            }
            if(readingDetailsDto.getSugarAtFast()!=null) {
                this.sugarAtFast = String.valueOf(readingDetailsDto.getSugarAtFast());
            }
            if(readingDetailsDto.getSugarAtFastTime()!=null) {
                this.sugarAtFastTime = readingDetailsDto.getSugarAtFastTime();
            }

            if(readingDetailsDto.getMrngInsulinBeforeFood()!=null) {
                this.mrngInsulinBeforeFood = String.valueOf(readingDetailsDto.getMrngInsulinBeforeFood());
            }
            if(readingDetailsDto.getMrngInsulinBeforeFoodTime()!=null) {
                this.mrngInsulinBeforeFoodTime = readingDetailsDto.getMrngInsulinBeforeFoodTime();
            }
            if(readingDetailsDto.getMrngInsulinAfterFood()!=null) {
                this.mrngInsulinAfterFood = String.valueOf(readingDetailsDto.getMrngInsulinAfterFood());
            }
            if(readingDetailsDto.getMrngInsulinAfterFoodTime()!=null) {
                this.mrngInsulinAfterFoodTime = readingDetailsDto.getMrngInsulinAfterFoodTime();
            }
            if(readingDetailsDto.getMrngPlace()!=null) {
                this.mrngPlace = readingDetailsDto.getMrngPlace();
            }
            if(readingDetailsDto.getMrngSugarBeforeFood()!=null) {
                this.mrngSugarBeforeFood = String.valueOf(readingDetailsDto.getMrngSugarBeforeFood());
            }
            if(readingDetailsDto.getMrngSugarBeforeFoodTime()!=null) {
                this.mrngSugarBeforeFoodTime = readingDetailsDto.getMrngSugarBeforeFoodTime();
            }
            if(readingDetailsDto.getMrngSugarAfterFood()!=null) {
                this.mrngSugarAfterFood = String.valueOf(readingDetailsDto.getMrngSugarAfterFood());
            }
            if(readingDetailsDto.getMrngSugarAfterFoodTime()!=null) {
                this.mrngSugarAfterFoodTime = readingDetailsDto.getMrngSugarAfterFoodTime();
            }

            if(readingDetailsDto.getNoonInsulinBeforeFood()!=null) {
                this.noonInsulinBeforeFood = String.valueOf(readingDetailsDto.getNoonInsulinBeforeFood());
            }
            if(readingDetailsDto.getNoonInsulinBeforeFoodTime()!=null) {
                this.noonInsulinBeforeFoodTime = readingDetailsDto.getNoonInsulinBeforeFoodTime();
            }
            if(readingDetailsDto.getNoonInsulinAfterFood()!=null) {
                this.noonInsulinAfterFood = String.valueOf(readingDetailsDto.getNoonInsulinAfterFood());
            }
            if(readingDetailsDto.getNoonInsulinAfterFoodTime()!=null) {
                this.noonInsulinAfterFoodTime = readingDetailsDto.getNoonInsulinAfterFoodTime();
            }
            if(readingDetailsDto.getNoonPlace()!=null) {
                this.noonPlace = readingDetailsDto.getNoonPlace();
            }
            if(readingDetailsDto.getNoonSugarBeforeFood()!=null) {
                this.noonSugarBeforeFood = String.valueOf(readingDetailsDto.getNoonSugarBeforeFood());
            }
            if(readingDetailsDto.getNoonSugarBeforeFoodTime()!=null) {
                this.noonSugarBeforeFoodTime = readingDetailsDto.getNoonSugarBeforeFoodTime();
            }
            if(readingDetailsDto.getNoonSugarAfterFood()!=null) {
                this.noonSugarAfterFood = String.valueOf(readingDetailsDto.getNoonSugarAfterFood());
            }
            if(readingDetailsDto.getNoonSugarAfterFoodTime()!=null) {
                this.noonSugarAfterFoodTime = readingDetailsDto.getNoonSugarAfterFoodTime();
            }

            if(readingDetailsDto.getEvngInsulinBeforeFood()!=null) {
                this.evngInsulinBeforeFood = String.valueOf(readingDetailsDto.getEvngInsulinBeforeFood());
            }
            if(readingDetailsDto.getEvngInsulinBeforeFoodTime()!=null) {
                this.evngInsulinBeforeFoodTime = readingDetailsDto.getEvngInsulinBeforeFoodTime();
            }
            if(readingDetailsDto.getEvngInsulinAfterFood()!=null) {
                this.evngInsulinAfterFood = String.valueOf(readingDetailsDto.getEvngInsulinAfterFood());
            }
            if(readingDetailsDto.getEvngInsulinAfterFoodTime()!=null) {
                this.evngInsulinAfterFoodTime = readingDetailsDto.getEvngInsulinAfterFoodTime();
            }
            if(readingDetailsDto.getEvngPlace()!=null) {
                this.evngPlace = readingDetailsDto.getEvngPlace();
            }
            if(readingDetailsDto.getEvngSugarBeforeFood()!=null) {
                this.evngSugarBeforeFood = String.valueOf(readingDetailsDto.getEvngSugarBeforeFood());
            }
            if(readingDetailsDto.getEvngSugarBeforeFoodTime()!=null) {
                this.evngSugarBeforeFoodTime = readingDetailsDto.getEvngSugarBeforeFoodTime();
            }
            if(readingDetailsDto.getEvngSugarAfterFood()!=null) {
                this.evngSugarAfterFood = String.valueOf(readingDetailsDto.getEvngSugarAfterFood());
            }
            if(readingDetailsDto.getEvngSugarAfterFoodTime()!=null) {
                this.evngSugarAfterFoodTime = readingDetailsDto.getEvngSugarAfterFoodTime();
            }
            if(readingDetailsDto.getComment()!=null) {
                this.comment = readingDetailsDto.getComment();
            }
        }else{
            this.setIsSave(Boolean.TRUE);
            Date now = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.date = dateFormat.format(now);
            DateFormat dayFormat = new SimpleDateFormat("EEEE",Locale.ENGLISH);
            this.day = dayFormat.format(now);
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getInsulinBeforeBed() {
        return insulinBeforeBed;
    }

    public void setInsulinBeforeBed(String insulinBeforeBed) {
        this.insulinBeforeBed = insulinBeforeBed;
    }

    public String getInsulinBeforeBedTime() {
        return insulinBeforeBedTime;
    }

    public void setInsulinBeforeBedTime(String insulinBeforeBedTime) {
        this.insulinBeforeBedTime = insulinBeforeBedTime;
    }

    public String getSugarAtFast() {
        return sugarAtFast;
    }

    public void setSugarAtFast(String sugarAtFast) {
        this.sugarAtFast = sugarAtFast;
    }

    public String getSugarAtFastTime() {
        return sugarAtFastTime;
    }

    public void setSugarAtFastTime(String sugarAtFastTime) {
        this.sugarAtFastTime = sugarAtFastTime;
    }

    public String getMrngInsulinBeforeFood() {
        return mrngInsulinBeforeFood;
    }

    public void setMrngInsulinBeforeFood(String mrngInsulinBeforeFood) {
        this.mrngInsulinBeforeFood = mrngInsulinBeforeFood;
    }

    public String getMrngInsulinBeforeFoodTime() {
        return mrngInsulinBeforeFoodTime;
    }

    public void setMrngInsulinBeforeFoodTime(String mrngInsulinBeforeFoodTime) {
        this.mrngInsulinBeforeFoodTime = mrngInsulinBeforeFoodTime;
    }

    public String getMrngInsulinAfterFood() {
        return mrngInsulinAfterFood;
    }

    public void setMrngInsulinAfterFood(String mrngInsulinAfterFood) {
        this.mrngInsulinAfterFood = mrngInsulinAfterFood;
    }

    public String getMrngInsulinAfterFoodTime() {
        return mrngInsulinAfterFoodTime;
    }

    public void setMrngInsulinAfterFoodTime(String mrngInsulinAfterFoodTime) {
        this.mrngInsulinAfterFoodTime = mrngInsulinAfterFoodTime;
    }

    public String getMrngPlace() {
        return mrngPlace;
    }

    public void setMrngPlace(String mrngPlace) {
        this.mrngPlace = mrngPlace;
    }

    public String getMrngSugarBeforeFood() {
        return mrngSugarBeforeFood;
    }

    public void setMrngSugarBeforeFood(String mrngSugarBeforeFood) {
        this.mrngSugarBeforeFood = mrngSugarBeforeFood;
    }

    public String getMrngSugarBeforeFoodTime() {
        return mrngSugarBeforeFoodTime;
    }

    public void setMrngSugarBeforeFoodTime(String mrngSugarBeforeFoodTime) {
        this.mrngSugarBeforeFoodTime = mrngSugarBeforeFoodTime;
    }

    public String getMrngSugarAfterFood() {
        return mrngSugarAfterFood;
    }

    public void setMrngSugarAfterFood(String mrngSugarAfterFood) {
        this.mrngSugarAfterFood = mrngSugarAfterFood;
    }

    public String getMrngSugarAfterFoodTime() {
        return mrngSugarAfterFoodTime;
    }

    public void setMrngSugarAfterFoodTime(String mrngSugarAfterFoodTime) {
        this.mrngSugarAfterFoodTime = mrngSugarAfterFoodTime;
    }

    public String getNoonInsulinBeforeFood() {
        return noonInsulinBeforeFood;
    }

    public void setNoonInsulinBeforeFood(String noonInsulinBeforeFood) {
        this.noonInsulinBeforeFood = noonInsulinBeforeFood;
    }

    public String getNoonInsulinBeforeFoodTime() {
        return noonInsulinBeforeFoodTime;
    }

    public void setNoonInsulinBeforeFoodTime(String noonInsulinBeforeFoodTime) {
        this.noonInsulinBeforeFoodTime = noonInsulinBeforeFoodTime;
    }

    public String getNoonInsulinAfterFood() {
        return noonInsulinAfterFood;
    }

    public void setNoonInsulinAfterFood(String noonInsulinAfterFood) {
        this.noonInsulinAfterFood = noonInsulinAfterFood;
    }

    public String getNoonInsulinAfterFoodTime() {
        return noonInsulinAfterFoodTime;
    }

    public void setNoonInsulinAfterFoodTime(String noonInsulinAfterFoodTime) {
        this.noonInsulinAfterFoodTime = noonInsulinAfterFoodTime;
    }

    public String getNoonPlace() {
        return noonPlace;
    }

    public void setNoonPlace(String noonPlace) {
        this.noonPlace = noonPlace;
    }

    public String getNoonSugarBeforeFood() {
        return noonSugarBeforeFood;
    }

    public void setNoonSugarBeforeFood(String noonSugarBeforeFood) {
        this.noonSugarBeforeFood = noonSugarBeforeFood;
    }

    public String getNoonSugarBeforeFoodTime() {
        return noonSugarBeforeFoodTime;
    }

    public void setNoonSugarBeforeFoodTime(String noonSugarBeforeFoodTime) {
        this.noonSugarBeforeFoodTime = noonSugarBeforeFoodTime;
    }

    public String getNoonSugarAfterFood() {
        return noonSugarAfterFood;
    }

    public void setNoonSugarAfterFood(String noonSugarAfterFood) {
        this.noonSugarAfterFood = noonSugarAfterFood;
    }

    public String getNoonSugarAfterFoodTime() {
        return noonSugarAfterFoodTime;
    }

    public void setNoonSugarAfterFoodTime(String noonSugarAfterFoodTime) {
        this.noonSugarAfterFoodTime = noonSugarAfterFoodTime;
    }

    public String getEvngInsulinBeforeFood() {
        return evngInsulinBeforeFood;
    }

    public void setEvngInsulinBeforeFood(String evngInsulinBeforeFood) {
        this.evngInsulinBeforeFood = evngInsulinBeforeFood;
    }

    public String getEvngInsulinBeforeFoodTime() {
        return evngInsulinBeforeFoodTime;
    }

    public void setEvngInsulinBeforeFoodTime(String evngInsulinBeforeFoodTime) {
        this.evngInsulinBeforeFoodTime = evngInsulinBeforeFoodTime;
    }

    public String getEvngInsulinAfterFood() {
        return evngInsulinAfterFood;
    }

    public void setEvngInsulinAfterFood(String evngInsulinAfterFood) {
        this.evngInsulinAfterFood = evngInsulinAfterFood;
    }

    public String getEvngInsulinAfterFoodTime() {
        return evngInsulinAfterFoodTime;
    }

    public void setEvngInsulinAfterFoodTime(String evngInsulinAfterFoodTime) {
        this.evngInsulinAfterFoodTime = evngInsulinAfterFoodTime;
    }

    public String getEvngPlace() {
        return evngPlace;
    }

    public void setEvngPlace(String evngPlace) {
        this.evngPlace = evngPlace;
    }

    public String getEvngSugarBeforeFood() {
        return evngSugarBeforeFood;
    }

    public void setEvngSugarBeforeFood(String evngSugarBeforeFood) {
        this.evngSugarBeforeFood = evngSugarBeforeFood;
    }

    public String getEvngSugarBeforeFoodTime() {
        return evngSugarBeforeFoodTime;
    }

    public void setEvngSugarBeforeFoodTime(String evngSugarBeforeFoodTime) {
        this.evngSugarBeforeFoodTime = evngSugarBeforeFoodTime;
    }

    public String getEvngSugarAfterFood() {
        return evngSugarAfterFood;
    }

    public void setEvngSugarAfterFood(String evngSugarAfterFood) {
        this.evngSugarAfterFood = evngSugarAfterFood;
    }

    public String getEvngSugarAfterFoodTime() {
        return evngSugarAfterFoodTime;
    }

    public void setEvngSugarAfterFoodTime(String evngSugarAfterFoodTime) {
        this.evngSugarAfterFoodTime = evngSugarAfterFoodTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsSave() {
        return isSave;
    }

    public void setIsSave(Boolean isSave) {
        this.isSave = isSave;
    }


    public ReadingService getService() {
        return service;
    }

    public void saveReading(){
        ReadingDetailsDto readingDetailsDto = new ReadingDetailsDto();
        readingDetailsDto.setDate(this.getDate());
        readingDetailsDto.setDay(this.getDay());
        readingDetailsDto.setUserId(Utilities.getUserId());

        if(this.getInsulinBeforeBed()!= null && !this.getInsulinBeforeBed().isEmpty()) {
            readingDetailsDto.setInsulinBeforeBed(Integer.parseInt(this.getInsulinBeforeBed()));
        }
        if(this.getInsulinBeforeBedTime()!=null && !this.getInsulinBeforeBedTime().isEmpty()) {
            readingDetailsDto.setInsulinBeforeBedTime(this.getInsulinBeforeBedTime());
        }
        if(this.getSugarAtFast()!=null && !this.getSugarAtFast().isEmpty()) {
            readingDetailsDto.setSugarAtFast(Integer.parseInt(this.getSugarAtFast()));
        }
        if(this.getSugarAtFastTime()!=null && !this.getSugarAtFastTime().isEmpty()) {
            readingDetailsDto.setSugarAtFastTime(this.getSugarAtFastTime());
        }

        if(this.getMrngInsulinBeforeFood()!=null && !this.getMrngInsulinBeforeFood().isEmpty()) {
            readingDetailsDto.setMrngInsulinBeforeFood(Integer.parseInt(this.getMrngInsulinBeforeFood()));
        }
        if(this.getMrngInsulinBeforeFoodTime()!=null && !this.getMrngInsulinBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setMrngInsulinBeforeFoodTime(this.getMrngInsulinBeforeFoodTime());
        }
        if(this.getMrngInsulinAfterFood()!=null && !this.getMrngInsulinAfterFood().isEmpty()) {
            readingDetailsDto.setMrngInsulinAfterFood(Integer.parseInt(this.getMrngInsulinAfterFood()));
        }
        if(this.getMrngInsulinAfterFoodTime()!=null && !this.getMrngInsulinAfterFoodTime().isEmpty()) {
            readingDetailsDto.setMrngInsulinAfterFoodTime(this.getMrngInsulinAfterFoodTime());
        }
        if(this.getMrngPlace()!=null && !this.getMrngPlace().isEmpty()) {
            readingDetailsDto.setMrngPlace(this.getMrngPlace());
        }
        if(this.getMrngSugarBeforeFood()!=null && !this.getMrngSugarBeforeFood().isEmpty()) {
            readingDetailsDto.setMrngSugarBeforeFood(Integer.parseInt(this.getMrngSugarBeforeFood()));
        }
        if(this.getMrngSugarBeforeFoodTime()!=null && !this.getMrngSugarBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setMrngSugarBeforeFoodTime(this.getMrngSugarBeforeFoodTime());
        }
        if(this.getMrngSugarAfterFood()!=null && !this.getMrngSugarAfterFood().isEmpty()) {
            readingDetailsDto.setMrngSugarAfterFood(Integer.parseInt(this.getMrngSugarAfterFood()));
        }
        if(this.getMrngSugarAfterFoodTime()!=null && !this.getMrngSugarAfterFoodTime().isEmpty()) {
            readingDetailsDto.setMrngSugarAfterFoodTime(this.getMrngSugarAfterFoodTime());
        }

        if(this.getNoonInsulinBeforeFood()!=null && !this.getNoonInsulinBeforeFood().isEmpty()) {
            readingDetailsDto.setNoonInsulinBeforeFood(Integer.parseInt(this.getNoonInsulinBeforeFood()));
        }
        if(this.getNoonInsulinBeforeFoodTime()!=null && !this.getNoonInsulinBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setNoonInsulinBeforeFoodTime(this.getNoonInsulinBeforeFoodTime());
        }
        if(this.getNoonInsulinAfterFood()!=null && !this.getNoonInsulinAfterFood().isEmpty()) {
            readingDetailsDto.setNoonInsulinAfterFood(Integer.parseInt(this.getNoonInsulinAfterFood()));
        }
        if(this.getNoonInsulinAfterFoodTime()!=null && !this.getNoonInsulinAfterFoodTime().isEmpty()) {
            readingDetailsDto.setNoonInsulinAfterFoodTime(this.getNoonInsulinAfterFoodTime());
        }
        if(this.getNoonPlace()!=null && !this.getNoonPlace().isEmpty()) {
            readingDetailsDto.setNoonPlace(this.getNoonPlace());
        }
        if(this.getNoonSugarBeforeFood()!=null && !this.getNoonSugarBeforeFood().isEmpty()) {
            readingDetailsDto.setNoonSugarBeforeFood(Integer.parseInt(this.getNoonSugarBeforeFood()));
        }
        if(this.getNoonSugarBeforeFoodTime() !=null && !this.getNoonSugarBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setNoonSugarBeforeFoodTime(this.getNoonSugarBeforeFoodTime());
        }
        if(this.getNoonSugarAfterFood()!=null && !this.getNoonSugarAfterFood().isEmpty()) {
            readingDetailsDto.setNoonSugarAfterFood(Integer.parseInt(this.getNoonSugarAfterFood()));
        }
        if(this.getNoonSugarAfterFoodTime()!=null && !this.getNoonSugarAfterFoodTime().isEmpty()) {
            readingDetailsDto.setNoonSugarAfterFoodTime(this.getNoonSugarAfterFoodTime());
        }

        if(this.getEvngInsulinBeforeFood()!=null && !this.getEvngInsulinBeforeFood().isEmpty()) {
            readingDetailsDto.setEvngInsulinBeforeFood(Integer.parseInt(this.getEvngInsulinBeforeFood()));
        }
        if(this.getEvngInsulinBeforeFoodTime()!=null && !this.getEvngInsulinBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setEvngInsulinBeforeFoodTime(this.getEvngInsulinBeforeFoodTime());
        }
        if(this.getEvngInsulinAfterFood()!=null && !this.getEvngInsulinAfterFood().isEmpty()) {
            readingDetailsDto.setEvngInsulinAfterFood(Integer.parseInt(this.getEvngInsulinAfterFood()));
        }
        if(this.getEvngInsulinAfterFoodTime()!=null && !this.getEvngInsulinAfterFoodTime().isEmpty()) {
            readingDetailsDto.setEvngInsulinAfterFoodTime(this.getEvngInsulinAfterFoodTime());
        }
        if(this.getEvngPlace()!=null && !this.getEvngPlace().isEmpty()) {
            readingDetailsDto.setEvngPlace(this.getEvngPlace());
        }
        if(this.getEvngSugarBeforeFood()!=null && !this.getEvngSugarBeforeFood().isEmpty()) {
            readingDetailsDto.setEvngSugarBeforeFood(Integer.parseInt(this.getEvngSugarBeforeFood()));
        }
        if(this.getEvngSugarBeforeFoodTime()!=null && !this.getEvngSugarBeforeFoodTime().isEmpty()) {
            readingDetailsDto.setEvngSugarBeforeFoodTime(this.getEvngSugarBeforeFoodTime());
        }
        if(this.getEvngSugarAfterFood()!=null && !this.getEvngSugarAfterFood().isEmpty()) {
            readingDetailsDto.setEvngSugarAfterFood(Integer.parseInt(this.getEvngSugarAfterFood()));
        }
        if(this.getEvngSugarAfterFoodTime()!=null && !this.getEvngSugarAfterFoodTime().isEmpty()) {
            readingDetailsDto.setEvngSugarAfterFoodTime(this.getEvngSugarAfterFoodTime());
        }

        if(this.getComment()!=null && !this.getComment().isEmpty()) {
            readingDetailsDto.setComment(this.getComment());
        }
        Client client = ClientBuilder.newClient();
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        if(this.getIsSave()){
            WebTarget clientTraget = client.target("http://localhost:8080").path("readings/");
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(readingDetailsDto);//Converting the Object to JSONString
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            response =  clientTraget.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonString));
        }else{
            WebTarget clientTraget = client.target("http://localhost:8080").path("readings/updateReadings");
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(readingDetailsDto);//Converting the Object to JSONString
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            response =  clientTraget.request(MediaType.APPLICATION_JSON).put(Entity.json(jsonString));
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
