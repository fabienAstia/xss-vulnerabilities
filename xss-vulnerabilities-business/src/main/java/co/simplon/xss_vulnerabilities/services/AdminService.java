package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.AdminView;
import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.repositories.AnswerRepository;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;

/**
 * Display informations: Instruction and Responses
 */
@Service
public class AdminService {
    private final InstructionRepository instructionRepository;
    private final AnswerRepository answerRepository;

    public AdminService(InstructionRepository instructionRepository, AnswerRepository answerRepository) {
	this.instructionRepository = instructionRepository;
	this.answerRepository = answerRepository;
    }

    /**
     *
     * @return all instructions and answers
     */
    public AdminView getAdminView() {
	List<InstructionView> allInstructions = instructionRepository.findAllProjectedByOrderById();
	List<AnswersView> allAnswers = answerRepository.findAllProjectedByOrderByIdDesc();
	return new AdminView(allInstructions, allAnswers);
    }
}
