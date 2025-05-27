package com.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.railway.dto.TrainDto;
import com.railway.entity.Train;
import com.railway.repo.TrainRepository;

public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository repo;
	
	@Override
	public TrainDto addTrain(TrainDto dto) {
		Train train = new Train();
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
		return repo.findById(trainId).orElseThrow(null);
	}

	@Override
	public List<Train> getTrainsByName(String trainName) {
		return repo.findByTrainNameContainingIgnoreCase(trainName);
	}

	@Override
	public List<Train> getTrainsByRoute(String source, String destination) {
		return repo.findBySourceAndDestinationContainingIgnoreCase(source, destination);
	}

	@Override
	public TrainDto updateTrain(Long trainId, TrainDto dto) {
		Train existingTrain = repo.findById(trainId).orElseThrow(null);

	        existingTrain.setTrainName(dto.getTrainName());
	        existingTrain.setSource(dto.getSource());
	        existingTrain.setDestination(dto.getDestination());
	        existingTrain.setDepartureTime(dto.getDepartureTime());
	        existingTrain.setArrivalTime(dto.getArrivalTime());
	        existingTrain.setClassFare(dto.getClassFare());
	        existingTrain.setQuotaFare(dto.getQuotaFare());

	        Train updatedTrain = repo.save(existingTrain);

	        TrainDto updatedDTO = new TrainDto();
	        updatedDTO.setTrainName(updatedTrain.getTrainName());
	        updatedDTO.setSource(updatedTrain.getSource());
	        updatedDTO.setDestination(updatedTrain.getDestination());
	        updatedDTO.setDepartureTime(updatedTrain.getDepartureTime());
	        updatedDTO.setArrivalTime(updatedTrain.getArrivalTime());
	        updatedDTO.setClassFare(updatedTrain.getClassFare());
	        updatedDTO.setQuotaFare(updatedTrain.getQuotaFare());

	        return updatedDTO;
	}

}
