package co.simplon.xss_vulnerabilities.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.ForumView;
import co.simplon.xss_vulnerabilities.dtos.InstructionUpdate;
import co.simplon.xss_vulnerabilities.dtos.ResponseCreate;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.entities.Response;
import co.simplon.xss_vulnerabilities.services.InstructionService;
import co.simplon.xss_vulnerabilities.services.ResponseService;

@RestController
@RequestMapping("/xss")
@CrossOrigin("*")
public class XssVulnerabilitiesController {

    private final ResponseService responseService;
    private final InstructionService instructionService;

    public XssVulnerabilitiesController(ResponseService responseService, InstructionService instructionService) {
	this.responseService = responseService;
	this.instructionService = instructionService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ForumView getForumView() {
	Optional<Instruction> instruction = instructionService.get();
	List<Response> response = responseService.getAllResponses();

	return new ForumView(instruction.get(), response);
    }

    @PostMapping("/response")
    public Response createResponse(ResponseCreate inputResponseDto) {
	return responseService.createResponse(inputResponseDto);
    }

    @PutMapping("/instruction")
    @ResponseStatus(code = HttpStatus.OK)
    public InstructionUpdate putMethodName(@RequestBody InstructionUpdate dto) {
	return instructionService.updateInstruction(dto);
    }
}
