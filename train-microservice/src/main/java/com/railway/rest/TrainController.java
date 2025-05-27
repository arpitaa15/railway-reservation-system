package com.railway.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.railway.dto.TrainDto;
import com.railway.entity.Train;
import com.railway.service.TrainService;


@RestController
public class TrainController {
	
	 	@Autowired
	    private TrainService trainService;

	    @PostMapping("/add")
	    public ResponseEntity<TrainDto> addTrain(@RequestBody TrainDto trainDTO) {
	        TrainDto savedTrain = trainService.addTrain(trainDTO);
	        return new ResponseEntity<>(savedTrain, HttpStatus.CREATED);
	    }

	    @GetMapping("/{trainId}")
	    public ResponseEntity<Train> getTrainById(@PathVariable Long trainId) {
	        Train train = trainService.getTrainById(trainId);
	        return ResponseEntity.ok(train);
	    }

	    @GetMapping("/listOfTrains")
	    public ResponseEntity<List<Train>> getAllTrains() {
	        List<Train> trains = trainService.getAllTrains();
	        return ResponseEntity.ok(trains);
	    }

	    @GetMapping("/search")
	    public ResponseEntity<List<Train>> getTrainsByName(@RequestParam String name) {
	        List<Train> trains = trainService.getTrainsByName(name);
	        return ResponseEntity.ok(trains);
	    }

	    @PutMapping("/{trainId}")
	    public ResponseEntity<TrainDto> updateTrain(
	            @PathVariable Long trainId,
	            @RequestBody TrainDto trainDTO) {
	        TrainDto updatedTrain = trainService.updateTrain(trainId, trainDTO);
	        return ResponseEntity.ok(updatedTrain);
	    }

}
