package com.example.weather.service;

import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
@Service
public class WeatherService {
 @Autowired
 private WeatherRepository repo;
  public List<Weather> getByDate(LocalDate date){
        return repo.findByDate(date);
    }
  public List<Weather> getAllSortedByTemp() {
       return repo.findAll(Sort.by("temperature"));
    }
    public Map<String, Double>getMonthlyStats(int year,int month){
      List<Weather>list=repo.findAll();
       List<Double>temps=new ArrayList<>();
 for(Weather w:list) {
      if(w.getDate().getYear()==year &&w.getDate().getMonthValue()==month){
             temps.add(w.getTemperature());
    }
}
  Collections.sort(temps);
        Map<String, Double> result=new HashMap<>();
if (!temps.isEmpty()){
      result.put("min", temps.get(0));
       result.put("max", temps.get(temps.size()-1));
       result.put("median",temps.get(temps.size()/2));
  }
  return result;
    }
}