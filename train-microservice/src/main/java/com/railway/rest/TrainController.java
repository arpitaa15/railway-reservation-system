package com.railway.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.railway.dto.TrainDto;
import com.railway.entity.Train;
import com.railway.service.TrainService;


@RestController
@RequestMapping("/trains")
public class TrainController {
	
	 	@Autowired
	    private TrainService trainService;

//	 	http://localhost:9003/trains/add
	    @PostMapping("/add")
	    public ResponseEntity<TrainDto> addTrain(@RequestBody TrainDto trainDTO) {
	        TrainDto savedTrain = trainService.addTrain(trainDTO);
	        return new ResponseEntity<>(savedTrain, HttpStatus.CREATED);
	    }
	    
//	    http://localhost:9003/trains/Id/12101
	    @GetMapping("/Id/{trainId}")
	    public ResponseEntity<Train> getTrainById(@PathVariable Long trainId) {
	        Train train = trainService.getTrainById(trainId);
	        return ResponseEntity.ok(train);
	    }

//	    http://localhost:9003/trains/listOfTrains
	    @GetMapping("/listOfTrains")
	    public ResponseEntity<List<Train>> getAllTrains() {
	        List<Train> trains = trainService.getAllTrains();
	        return ResponseEntity.ok(trains);
	    }

//	    http://localhost:9003/trains/search/
	    @GetMapping("/search/{trainName}")
	    public ResponseEntity<Train> getTrainByName(@PathVariable String trainName) {
	        Train train = trainService.getTrainByName(trainName);
	        return ResponseEntity.ok(train);
	    }

//	    http://localhost:9003/trains/update/{trainId}
	    @PutMapping("/update/{trainId}")
	    public ResponseEntity<TrainDto> updateTrain(
	            @PathVariable Long trainId,
	            @RequestBody TrainDto trainDTO) {
	        TrainDto updatedTrain = trainService.updateTrain(trainId, trainDTO);
	        return ResponseEntity.ok(updatedTrain);
	    }

//	    http://localhost:9003/trains/delete/{trainId}
	    @DeleteMapping("/delete/{trainId}")
	    public ResponseEntity<String> deleteTrain(@PathVariable Long trainId) {
			trainService.deleteTrain(trainId);
			return new ResponseEntity<String> ("Train with Id " + trainId + " deleted successfully.", HttpStatus.OK);
	    }
}
