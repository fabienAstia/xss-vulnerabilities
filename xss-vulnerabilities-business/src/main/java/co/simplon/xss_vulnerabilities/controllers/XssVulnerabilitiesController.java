package co.simplon.xss_vulnerabilities.controllers;

import java.util.List;

import co.simplon.xss_vulnerabilities.dtos.*;
import co.simplon.xss_vulnerabilities.services.AnswerService;
import co.simplon.xss_vulnerabilities.services.ForumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.simplon.xss_vulnerabilities.services.InstructionService;

@RestController
@RequestMapping("/xss")
@CrossOrigin("*")
public class XssVulnerabilitiesController {

    private final AnswerService answerService;
    private final InstructionService instructionService;
    private final ForumService forumService;

    public XssVulnerabilitiesController(AnswerService answerService, InstructionService instructionService, ForumService forumService) {
        this.answerService = answerService;
        this.instructionService = instructionService;
        this.forumService = forumService;
    }

    @PostMapping("/response")
    public void createAnswer(@RequestBody AnswerCreate inputResponseDto) {
	     answerService.createAnswer(inputResponseDto);
    }

    @GetMapping("/response")
    public List<AnswersView>  getAnswers(){
        return answerService.getAllAnswers();
    }

    @GetMapping("/instruction")
    public List<InstructionView> getAllInstructions(){
        return instructionService.getAllInstructions();
    }

    @GetMapping("/instruction/{id}")
    public InstructionView getOneInstruction(@PathVariable("id") Long id){
        return instructionService.getOneInstruction(id);
    }

    @PostMapping("/instruction")
    @ResponseStatus(code = HttpStatus.OK)
    public void createInstruction(@Valid @RequestBody InstructionCreate newInstruction) {
        instructionService.createInstruction(newInstruction);
    }

    @PutMapping("/instruction")
    @ResponseStatus(code = HttpStatus.OK)
    public InstructionUpdate putMethodName(@RequestBody InstructionUpdate dto) {
        return instructionService.updateInstruction(dto);
    }

    @GetMapping("/forum")
    public ForumView getForumView(){
        return forumService.getForumView();

    }

}
