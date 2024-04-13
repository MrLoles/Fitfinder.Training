package pl.fitfinder.microservices.fitfinder.trainingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.trainingService.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
