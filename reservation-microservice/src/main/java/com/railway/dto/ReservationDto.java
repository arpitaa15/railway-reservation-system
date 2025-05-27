package com.railway.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	
	private String passengerName;
    private String gender;
    private int age;
    private String address;

    private Long trainId;
    private String trainName;
    
    private String travelClass;  // Example: "Sleeper", "AC"
    private String quota;        // Example: "General", "Ladies"

    private LocalDate travelDate;
    private int numberOfSeats;

    private String pnr;

    private Double totalFare;

    private LocalDateTime bookingTime;
    
}
