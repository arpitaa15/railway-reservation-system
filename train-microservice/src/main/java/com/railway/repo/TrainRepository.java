package com.railway.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
	
	List<Train> findByTrainNameContainingIgnoreCase(String trainName);
	
	List<Train> findBySourceAndDestinationContainingIgnoreCase(String source, String destination);

}
