package com.railway.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Reservation {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long reservationId;

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

	    private LocalDateTime bookingTime = LocalDateTime.now();

}
