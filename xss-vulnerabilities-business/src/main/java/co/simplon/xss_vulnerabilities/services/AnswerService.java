package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.AnswerCreate;
import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.entities.Answer;
import co.simplon.xss_vulnerabilities.repositories.AnswerRepository;

@Service
public class AnswerService {

    private final AnswerRepository repository;

    public AnswerService(AnswerRepository answerRepository) {
	this.repository = answerRepository;
    }

    public List<AnswersView> getAllAnswers() {
	return repository.findAllProjectedByOrderByIdDesc();
    }

    public void createAnswer(AnswerCreate inputResponseDto) {
	Answer answer = new Answer();
	answer.setFirstname(inputResponseDto.firstname());
	answer.setAnswer(inputResponseDto.response());
	System.out.println("answer :" + answer);
	System.out.println("inputResponseDto.response :" + inputResponseDto.response());
	repository.save(answer);
    }

    public void deleteOne(Long id) {
	repository.deleteById(id);
    }

}
