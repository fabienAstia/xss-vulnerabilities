package co.simplon.xss_vulnerabilities.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.AnswerCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.services.AnswerService;
import co.simplon.xss_vulnerabilities.services.InstructionService;

@RestController
@RequestMapping("/xss/response")
@CrossOrigin("*")
public class ResponseController {
    private final AnswerService answerService;
    private final InstructionService instructionService;

    public ResponseController(AnswerService answerService, InstructionService instructionService) {
	this.answerService = answerService;
	this.instructionService = instructionService;
    }

    @GetMapping
    public InstructionView getInstructionView() {
	return instructionService.getLastInstruction();
    }

    @PostMapping
    public void createAnswer(@RequestBody AnswerCreate inputResponseDto) {
	answerService.createAnswer(inputResponseDto);
    }

}
