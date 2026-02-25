package com.example.weather.loader;

import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CsvLoader{
  @Autowired
    private WeatherRepository repo;
  @PostConstruct
    public void loadData(){
try{
BufferedReader br=new BufferedReader(
                   new InputStreamReader(
                    new ClassPathResource("testset.csv").getInputStream())
  );
String line;
br.readLine(); 

            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");
while((line=br.readLine())!=null){
   if (line.trim().isEmpty()) 
	   continue;
  String[] data=line.split(",");
                if(data.length < 6) 
                	continue;
                Weather w=new Weather();
 w.setDate(LocalDate.parse(data[0].trim(),formatter));
  w.setCondition(data[1].trim());
   w.setTemperature(parseDoubleSafe(data[2]));
   w.setHumidity(parseDoubleSafe(data[3]));
  w.setPressure(parseDoubleSafe(data[4]));
  w.setHeatIndex(parseDoubleSafe(data[5]));
        repo.save(w);
   }
 br.close();
System.out.println("CSV Data Loaded Successfully!");
} 
catch (Exception e){
            e.printStackTrace();
      }
    }
 private double parseDoubleSafe(String value){
        try{
            if(value==null||value.trim().isEmpty()){
                return 0;
            }
            return Double.parseDouble(value.trim());
        } 
        catch (Exception e) {
            return 0;
        }
    }
}