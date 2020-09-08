package com.example.weather.model;

public class Temperature {
    private Double Value;
    private String Unit;

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        this.Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        this.Unit = unit;
    }
}
