package co.simplon.xss_vulnerabilities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<AnswersView> findAllProjectedByOrderByIdDesc();
}
