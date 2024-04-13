package pl.fitfinder.microservices.fitfinder.trainingService.service.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.trainingService.exception.exceptions.WrongDayOfWeekException;
import pl.fitfinder.microservices.fitfinder.trainingService.model.Exercise;
import pl.fitfinder.microservices.fitfinder.trainingService.model.Training;
import pl.fitfinder.microservices.fitfinder.trainingService.repository.ExerciseRepository;
import pl.fitfinder.microservices.fitfinder.trainingService.repository.TrainingRepository;
import pl.fitfinder.microservices.fitfinder.trainingService.utils.Methods;

import java.util.List;
import java.util.stream.Collectors;

import static pl.fitfinder.microservices.fitfinder.trainingService.utils.JwtTokenManager.getUserId;

@Service
public class TrainingServiceImpl implements TrainingService{

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    public void addTraining(String token, Training trainingToSave){
        int idUser = Integer.parseInt(getUserId(token));

        List<Training> trainings = trainingRepository.findByUserId(idUser);
        trainings.forEach(t -> {
            if(t.getDayOfWeek() == trainingToSave.getDayOfWeek()) trainingRepository.delete(t);;
        });

        trainingToSave.setUserId(idUser);

        trainingRepository.save(trainingToSave);

        for(Exercise exercise : trainingToSave.getExercises()){
            exercise.setTraining(trainingToSave);
            exerciseRepository.save(exercise);
        }
    }

    public List<Training> getTrainings(String token){
        int idUser = Integer.parseInt(getUserId(token));

        return trainingRepository.findByUserId(idUser);
    }

    public Training getTraining(String token, String dayOfWeekNumber){
        if(!Methods.isInteger(dayOfWeekNumber)) throw new WrongDayOfWeekException("Remember to use day numbers from 1 - 7");

        String idUser = getUserId(token);
        List<Training> trainingList = trainingRepository.findByUserId(Integer.parseInt(idUser));

        return trainingList.stream().filter(training -> Integer.toString(training.getDayOfWeek()).equals(dayOfWeekNumber)).findFirst().orElse(null);
    }

    public String deleteTraining(String token, String dayOfWeekNumber){
        if(!Methods.isInteger(dayOfWeekNumber)) throw new WrongDayOfWeekException("Remember to use day numbers from 1 - 7");
        int idUser = Integer.parseInt(getUserId(token));

        List<Training> foundTrainings = trainingRepository.findByUserIdAndDayOfWeek(idUser, Integer.parseInt(dayOfWeekNumber));
        if(foundTrainings.isEmpty()) throw new WrongDayOfWeekException("User doesn't have training scheduled for the provided day of the week");

        trainingRepository.deleteAll(foundTrainings);

        return "Success";
    }
}
