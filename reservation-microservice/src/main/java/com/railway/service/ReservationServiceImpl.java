package com.railway.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.dto.ReservationDto;
import com.railway.entity.Reservation;
import com.railway.repo.ReservationRepository;

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repo;
	
	@Override
	public ReservationDto bookTicket(ReservationDto dto) {
		
		Reservation reservation = new Reservation();

        // Manual mapping from DTO to Entity
        reservation.setPassengerName(dto.getPassengerName());
        reservation.setGender(dto.getGender());
        reservation.setAge(dto.getAge());
        reservation.setAddress(dto.getAddress());
        reservation.setTrainId(dto.getTrainId());
        reservation.setTrainName(dto.getTrainName());
        reservation.setTravelClass(dto.getTravelClass());
        reservation.setQuota(dto.getQuota());
        reservation.setTravelDate(dto.getTravelDate());
        reservation.setNumberOfSeats(dto.getNumberOfSeats());

        // Business logic
        reservation.setPnr(generatePNR());
        reservation.setBookingTime(LocalDateTime.now());

        double totalFare = calculateFare(dto.getTrainId(), dto.getTravelClass(), dto.getQuota(), dto.getNumberOfSeats());
        reservation.setTotalFare(totalFare);

        // Save to DB
        Reservation saved = repo.save(reservation);

        ReservationDto response = new ReservationDto();
        response.setPassengerName(saved.getPassengerName());
        response.setGender(saved.getGender());
        response.setAge(saved.getAge());
        response.setAddress(saved.getAddress());
        response.setTrainId(saved.getTrainId());
        response.setTrainName(saved.getTrainName());
        response.setTravelClass(saved.getTravelClass());
        response.setQuota(saved.getQuota());
        response.setTravelDate(saved.getTravelDate());
        response.setNumberOfSeats(saved.getNumberOfSeats());
        response.setTotalFare(saved.getTotalFare());
        response.setPnr(saved.getPnr());
        response.setBookingTime(saved.getBookingTime());
		return response;
	}

	@Override
	public ReservationDto getReservationByPnr(String pnr) {
		return null;
	}

//	@Override
//	public List<ReservationDto> getReservationsByUserId(Long userId) {
//		return null;
//	}

	private String generatePNR() {
        return "PNR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
	
	private double calculateFare(Long trainId, String travelClass, String quota, int seats) {
	    double baseFare = 100.0; // base fare for calculation, you can fetch from DB later

	    // Class fare multiplier
	    if ("AC".equalsIgnoreCase(travelClass)) {
	        baseFare *= 2.0;
	    } else if ("Sleeper".equalsIgnoreCase(travelClass)) {
	        baseFare *= 1.5;
	    } else {
	        // Assuming "General" or any other class has no multiplier
	    }

	    // Quota fare adjustment
	    if ("Ladies".equalsIgnoreCase(quota)) {
	        baseFare *= 0.9;  // 10% discount for Ladies quota
	    } else if ("General".equalsIgnoreCase(quota)) {
	        // No discount or surcharge
	    } else {
	        // Handle other quotas if needed or no change
	    }

	    return baseFare * seats;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return repo.findAll();
	}

}
