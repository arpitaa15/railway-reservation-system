package com.railway.service;

import java.util.List;

import com.railway.dto.ReservationDto;
import com.railway.entity.Reservation;

public interface ReservationService {
	
	ReservationDto bookTicket(ReservationDto reservationDTO);

    ReservationDto getReservationByPnr(String pnr);

    //List<ReservationDto> getReservationsByUserId(Long userId);
    
    List<Reservation> getAllReservations();

}
