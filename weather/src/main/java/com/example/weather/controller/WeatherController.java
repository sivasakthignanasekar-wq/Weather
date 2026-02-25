package com.example.weather.controller;
import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController{
@Autowired
  private WeatherRepository repo;
@GetMapping
   public List<Weather> getAllWeather(){
        return repo.findAll();
  }
 @GetMapping("/filter")
    public List<Weather> filterByCondition(@RequestParam String condition){
        return repo.findByCondition(condition);
    }
 @GetMapping("/filter/date")
    public List<Weather> filterByDate(@RequestParam LocalDate date){
        return repo.findByDate(date);
    }
@GetMapping("/sort")
    public List<Weather> sortByTemperature(@RequestParam String direction){
if(direction.equalsIgnoreCase("desc")){
        return repo.findAll(Sort.by("temperature").descending());
  }
        return repo.findAll(Sort.by("temperature").ascending());
    }
}