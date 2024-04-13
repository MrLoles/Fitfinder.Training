package pl.fitfinder.microservices.fitfinder.trainingService.service.training;

import pl.fitfinder.microservices.fitfinder.trainingService.model.Training;

public interface TrainingService {
    void addTraining(String token, Training training);
}
