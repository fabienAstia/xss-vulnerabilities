package co.simplon.xss_vulnerabilities.services;

import co.simplon.xss_vulnerabilities.dtos.AnswersView;
import co.simplon.xss_vulnerabilities.dtos.ForumView;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;
import co.simplon.xss_vulnerabilities.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    private final InstructionRepository instructionRepository;
    private final AnswerRepository answerRepository;

    public ForumService(InstructionRepository instructionRepository, AnswerRepository answerRepository) {
        this.instructionRepository = instructionRepository;
        this.answerRepository = answerRepository;
    }

    public ForumView getForumView(){
        InstructionView instructionView = instructionRepository.findProjectedById(1L);
        List<AnswersView> answers = answerRepository.findAllProjectedBy();
        return new ForumView(instructionView, answers);
    }
}