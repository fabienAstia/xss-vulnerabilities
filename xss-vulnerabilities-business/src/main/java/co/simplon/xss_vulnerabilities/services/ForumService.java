package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.dtos.ForumView;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.repositories.AnswerRepository;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;

/**
 * Display current instruction and all responses in Forum page
 */
@Service
public class ForumService {

    private final InstructionRepository instructionRepository;
    private final AnswerRepository answerRepository;

    public ForumService(InstructionRepository instructionRepository, AnswerRepository answerRepository) {
	this.instructionRepository = instructionRepository;
	this.answerRepository = answerRepository;
    }

    /**
     *
     * @return currentInstruction and answers
     */
    public ForumView getForumView() {
	InstructionView currentInstruction = instructionRepository.findTopByOrderByIdDesc();
	List<AnswersView> answers = answerRepository.findAllProjectedByOrderByIdDesc();
	return new ForumView(currentInstruction, answers);
    }
}
