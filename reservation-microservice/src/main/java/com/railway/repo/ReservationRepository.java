package com.railway.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
