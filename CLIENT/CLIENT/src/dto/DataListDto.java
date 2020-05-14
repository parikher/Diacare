package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DataListDto implements Serializable {

    private Integer userId;
    private String date;
    private String day;
    private String nightInsulinBeforeBed;
    private String nightSugarAtFast;
    private String morningInsulinBeforeFood;
    private String morningInsulinAfterFood;
    private String morningPlace;
    private String morningSugarBeforeFood;
    private String morningSugarAfterFood;
    private String noonInsulinBeforeFood;
    private String noonInsulinAfterFood;
    private String noonPlace;
    private String noonSugarBeforeFood;
    private String noonSugarAfterFood;
    private String eveningInsulinBeforeFood;
    private String eveningInsulinAfterFood;
    private String eveningPlace;
    private String eveningSugarBeforeFood;
    private String eveningSugarAfterFood;

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

    public String getNightInsulinBeforeBed() {
        return nightInsulinBeforeBed;
    }

    public void setNightInsulinBeforeBed(String nightInsulinBeforeBed) {
        this.nightInsulinBeforeBed = nightInsulinBeforeBed;
    }

    public String getNightSugarAtFast() {
        return nightSugarAtFast;
    }

    public void setNightSugarAtFast(String nightSugarAtFast) {
        this.nightSugarAtFast = nightSugarAtFast;
    }

    public String getMorningInsulinBeforeFood() {
        return morningInsulinBeforeFood;
    }

    public void setMorningInsulinBeforeFood(String morningInsulinBeforeFood) {
        this.morningInsulinBeforeFood = morningInsulinBeforeFood;
    }

    public String getMorningInsulinAfterFood() {
        return morningInsulinAfterFood;
    }

    public void setMorningInsulinAfterFood(String morningInsulinAfterFood) {
        this.morningInsulinAfterFood = morningInsulinAfterFood;
    }

    public String getMorningPlace() {
        return morningPlace;
    }

    public void setMorningPlace(String morningPlace) {
        this.morningPlace = morningPlace;
    }

    public String getMorningSugarBeforeFood() {
        return morningSugarBeforeFood;
    }

    public void setMorningSugarBeforeFood(String morningSugarBeforeFood) {
        this.morningSugarBeforeFood = morningSugarBeforeFood;
    }

    public String getMorningSugarAfterFood() {
        return morningSugarAfterFood;
    }

    public void setMorningSugarAfterFood(String morningSugarAfterFood) {
        this.morningSugarAfterFood = morningSugarAfterFood;
    }

    public String getNoonInsulinBeforeFood() {
        return noonInsulinBeforeFood;
    }

    public void setNoonInsulinBeforeFood(String noonInsulinBeforeFood) {
        this.noonInsulinBeforeFood = noonInsulinBeforeFood;
    }

    public String getNoonInsulinAfterFood() {
        return noonInsulinAfterFood;
    }

    public void setNoonInsulinAfterFood(String noonInsulinAfterFood) {
        this.noonInsulinAfterFood = noonInsulinAfterFood;
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

    public String getNoonSugarAfterFood() {
        return noonSugarAfterFood;
    }

    public void setNoonSugarAfterFood(String noonSugarAfterFood) {
        this.noonSugarAfterFood = noonSugarAfterFood;
    }

    public String getEveningInsulinBeforeFood() {
        return eveningInsulinBeforeFood;
    }

    public void setEveningInsulinBeforeFood(String eveningInsulinBeforeFood) {
        this.eveningInsulinBeforeFood = eveningInsulinBeforeFood;
    }

    public String getEveningInsulinAfterFood() {
        return eveningInsulinAfterFood;
    }

    public void setEveningInsulinAfterFood(String eveningInsulinAfterFood) {
        this.eveningInsulinAfterFood = eveningInsulinAfterFood;
    }

    public String getEveningPlace() {
        return eveningPlace;
    }

    public void setEveningPlace(String eveningPlace) {
        this.eveningPlace = eveningPlace;
    }

    public String getEveningSugarBeforeFood() {
        return eveningSugarBeforeFood;
    }

    public void setEveningSugarBeforeFood(String eveningSugarBeforeFood) {
        this.eveningSugarBeforeFood = eveningSugarBeforeFood;
    }

    public String getEveningSugarAfterFood() {
        return eveningSugarAfterFood;
    }

    public void setEveningSugarAfterFood(String eveningSugarAfterFood) {
        this.eveningSugarAfterFood = eveningSugarAfterFood;
    }
}
