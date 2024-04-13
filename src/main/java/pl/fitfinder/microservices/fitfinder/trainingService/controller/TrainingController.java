package pl.fitfinder.microservices.fitfinder.trainingService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fitfinder.microservices.fitfinder.trainingService.model.Training;
import pl.fitfinder.microservices.fitfinder.trainingService.service.training.TrainingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingServiceImpl trainingService;

    @PostMapping("/add")
    public ResponseEntity<String> addTraining(@RequestHeader("token") String token, @RequestBody Training training){
        trainingService.addTraining(token, training);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    @GetMapping("/getAll")
    public List<Training> getAllTrainings(@RequestHeader("token") String token){
        System.out.println(token + " brak");
        return trainingService.getTrainings(token);
    }

    @GetMapping("/get/{dayOfWeekNumber}")
    public Training getSpecificTraining(@RequestHeader("token") String token, @PathVariable("dayOfWeekNumber") String dayOfWeekNumber){
        return trainingService.getTraining(token, dayOfWeekNumber);
    }

    @GetMapping("/delete/{dayOfWeekNumber}")
    public String deleteSpecificTraining(@RequestHeader("token") String token, @PathVariable("dayOfWeekNumber") String dayOfWeekNumber){
        return trainingService.deleteTraining(token, dayOfWeekNumber);
    }
}
