package com.example.weather.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="weather_data")
public class Weather {
    @Id
     @SequenceGenerator(
      name="weather_seq",
      sequenceName="weather_data_seq",
      allocationSize=1
    )
  @GeneratedValue(
     strategy=GenerationType.SEQUENCE,
     generator="weather_seq"
    )
 private Long id;
  @Column(name="weather_date")
      private LocalDate date;
  @Column(name="weather_condition")
    private String condition;

   private double temperature;
     private double humidity;
      private double pressure;

    @Column(name = "heat_index")
  private double heatIndex;
public Long getId(){
        return id;
    }
public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(double heatIndex) {
        this.heatIndex = heatIndex;
    }
}