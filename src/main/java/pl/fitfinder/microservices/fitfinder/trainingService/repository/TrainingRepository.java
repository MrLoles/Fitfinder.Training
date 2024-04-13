package pl.fitfinder.microservices.fitfinder.trainingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.trainingService.model.Training;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
    List<Training> findByUserId(int userId);
    List<Training> findByUserIdAndDayOfWeek(int userId, int dayOfWeek);
}
