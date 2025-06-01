package com.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.dto.TrainDto;
import com.railway.entity.Train;
import com.railway.exception.TrainNameNotFoundException;
import com.railway.exception.TrainNotFoundException;
import com.railway.repo.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository repo;
	
	@Override
	public TrainDto addTrain(TrainDto dto) {
		Train train = new Train();
		train.setTrainId(dto.getTrainId());
		train.setTrainName(dto.getTrainName());
		train.setDepartureTime(dto.getDepartureTime());
		train.setArrivalTime(dto.getArrivalTime());
		train.setDate(dto.getDate());
		train.setSource(dto.getSource());
		train.setDestination(dto.getDestination());
		train.setClassFare(dto.getClassFare());
		train.setQuotaFare(dto.getQuotaFare());
		train.setTotalSeats(dto.getTotalSeats());
		
		Train savedTrain = repo.save(train);
		
		TrainDto result = new TrainDto();
		result.setTrainId(savedTrain.getTrainId());
		result.setTrainName(savedTrain.getTrainName());
		result.setDepartureTime(savedTrain.getDepartureTime());
		result.setArrivalTime(savedTrain.getArrivalTime());
		result.setDate(savedTrain.getDate());
		result.setSource(savedTrain.getSource());
		result.setDestination(savedTrain.getDestination());
		result.setClassFare(savedTrain.getClassFare());
		result.setQuotaFare(savedTrain.getQuotaFare());
		result.setTotalSeats(savedTrain.getTotalSeats());
		
		return result;
	}

	@Override
	public List<Train> getAllTrains() {
		return repo.findAll();
	}

	@Override
	public Train getTrainById(Long trainId) {
		return repo.findById(trainId).orElseThrow(() -> new TrainNotFoundException("Train with id : " + trainId + " doesn't exist"));
	}

	@Override
	public Train getTrainByName(String trainName) {
		return repo.findByTrainNameContainingIgnoreCase(trainName).orElseThrow(()-> new TrainNameNotFoundException("Train with name : " + trainName + "doesn't exist"));
	}

	@Override
	public List<Train> getTrainsByRoute(String source, String destination) {
		return repo.findBySourceAndDestinationContainingIgnoreCase(source, destination);
	}

	@Override
	public TrainDto updateTrain(Long trainId, TrainDto dto) {
		Train existingTrain = repo.findById(trainId).orElseThrow(null);
		if(dto.getTrainName() != null) existingTrain.setTrainName(dto.getTrainName());
	    if(dto.getSource() != null) existingTrain.setSource(dto.getSource());
	    if(dto.getDestination()  != null) existingTrain.setDestination(dto.getDestination());
	    if(dto.getDepartureTime() != null) existingTrain.setDepartureTime(dto.getDepartureTime());
	    if(dto.getArrivalTime() != null) existingTrain.setArrivalTime(dto.getArrivalTime());
	    if(dto.getClassFare() != null) existingTrain.setClassFare(dto.getClassFare());
	    if(dto.getQuotaFare() != null) existingTrain.setQuotaFare(dto.getQuotaFare());
	    if(dto.getDate() != null) existingTrain.setDate(dto.getDate());
	    if(dto.getTotalSeats() != 0) existingTrain.setTotalSeats(dto.getTotalSeats());

	        Train updatedTrain = repo.save(existingTrain);
	        
	        TrainDto updatedDTO = new TrainDto();
	        updatedDTO.setTrainId(updatedTrain.getTrainId());
	        updatedDTO.setTrainName(updatedTrain.getTrainName());
	        updatedDTO.setSource(updatedTrain.getSource());
	        updatedDTO.setDestination(updatedTrain.getDestination());
	        updatedDTO.setDepartureTime(updatedTrain.getDepartureTime());
	        updatedDTO.setArrivalTime(updatedTrain.getArrivalTime());
	        updatedDTO.setClassFare(updatedTrain.getClassFare());
	        updatedDTO.setQuotaFare(updatedTrain.getQuotaFare());

	        return updatedDTO;
	}

	@Override
	public void deleteTrain(Long trainId) {
		repo.findById(trainId).orElseThrow(() -> new TrainNotFoundException("Train with id : " + trainId + " doesn't exist"));
		repo.deleteById(trainId);
	}

}
