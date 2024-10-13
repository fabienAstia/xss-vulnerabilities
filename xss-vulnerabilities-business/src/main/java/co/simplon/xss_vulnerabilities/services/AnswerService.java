package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.entities.Answer;
import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.AnswerCreate;
import co.simplon.xss_vulnerabilities.repositories.AnswerRepository;

@Service
public class AnswerService {

    private final AnswerRepository repository;

    public AnswerService(AnswerRepository answerRepository) {
	this.repository = answerRepository;
    }

    public List<AnswersView> getAllAnswers() {
		return repository.findAllProjectedBy();
    }

    public void createAnswer(AnswerCreate inputResponseDto) {
		Answer answer = new Answer();
		answer.setFirstname(inputResponseDto.firstname());
		answer.setAnswer(inputResponseDto.answer());
        repository.save(answer);
    }

}
