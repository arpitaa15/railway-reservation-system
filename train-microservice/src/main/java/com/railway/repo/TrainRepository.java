package com.railway.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
	
	Optional<Train> findByTrainNameContainingIgnoreCase(String trainName);
	
	List<Train> findBySourceAndDestinationContainingIgnoreCase(String source, String destination);

}
