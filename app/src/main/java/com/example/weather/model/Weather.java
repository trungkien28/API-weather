package com.example.weather.model;

public class Weather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        this.DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.IconPhrase = iconPhrase;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.Temperature = temperature;
    }
}
