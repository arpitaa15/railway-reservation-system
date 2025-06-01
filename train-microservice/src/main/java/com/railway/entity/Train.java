package com.railway.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Train {
	
	@Id
    private Long trainId;
    private String trainName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate date;
    private int totalSeats;

    @ElementCollection
    private Map<String, Double> classFare;   // e.g., Sleeper -> 300.0, AC -> 800.0

    @ElementCollection
    private Map<String, Double> quotaFare; // e.g., General -> 0.0, Ladies -> -50.0 (discount)

}
