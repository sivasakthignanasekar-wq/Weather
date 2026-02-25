package com.example.weather.repository;

import com.example.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByDate(LocalDate date);
    List<Weather> findByCondition(String condition);
    List<Weather> findByDateBetween(LocalDate startDate, LocalDate endDate);

}