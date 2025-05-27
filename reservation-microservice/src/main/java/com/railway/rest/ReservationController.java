package com.railway.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.railway.dto.ReservationDto;
import com.railway.entity.Reservation;
import com.railway.service.ReservationService;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	  @PostMapping
	    public ResponseEntity<ReservationDto> bookTicket(@RequestBody ReservationDto reservationDTO) {
	        ReservationDto booked = service.bookTicket(reservationDTO);
	        return ResponseEntity.ok(booked);
	    }
	  
	  @GetMapping
	    public ResponseEntity<List<Reservation>> getAllReservations() {
	        List<Reservation> list = service.getAllReservations();
	        return ResponseEntity.ok(list);
	    }

}
