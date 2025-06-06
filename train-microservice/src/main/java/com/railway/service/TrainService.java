package com.railway.service;

import java.util.List;

import com.railway.dto.TrainDto;
import com.railway.entity.Train;

public interface TrainService {
	
	TrainDto addTrain(TrainDto dto);
	List<Train> getAllTrains();
	Train getTrainById(Long trainId);
	Train getTrainByName(String trainName);
	List<Train> getTrainsByRoute(String source, String destination);
	TrainDto updateTrain(Long trainId, TrainDto dto);
	void deleteTrain(Long trainId);
	
}
