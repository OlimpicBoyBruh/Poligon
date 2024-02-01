package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.LearningClass;

/**
 * Репозиторий для управления БД LearningClass.
 */
@Repository
public interface LearningClassRepository extends JpaRepository<LearningClass, String> {
}
