package co.simplon.xss_vulnerabilities.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.AdminView;
import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.services.AdminService;
import co.simplon.xss_vulnerabilities.services.AnswerService;
import co.simplon.xss_vulnerabilities.services.InstructionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/xss/instruction")
@CrossOrigin("*")
public class InstructionController {
    private final InstructionService instructionService;
    private final AnswerService answerService;
    private final AdminService adminService;

    public InstructionController(InstructionService instructionService, AnswerService answerService,
	    AdminService adminService) {
	this.instructionService = instructionService;
	this.answerService = answerService;
	this.adminService = adminService;
    }

//  @GetMapping
//  public List<InstructionView> getAllInstructions() {
//	return instructionService.getAllInstructions();
//  }

    @GetMapping
    public AdminView getAllViews() {
	return adminService.getAdminView();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void createInstruction(@Valid @RequestBody InstructionCreate newInstruction) {
	instructionService.createInstruction(newInstruction);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable("id") Long id) {
	answerService.deleteOne(id);
    }

}
