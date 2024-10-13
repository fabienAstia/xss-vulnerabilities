package co.simplon.xss_vulnerabilities.controllers;

import java.util.List;
import java.util.Optional;

import co.simplon.xss_vulnerabilities.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/response")
    public void createResponse(@RequestBody ResponseCreate inputResponseDto) {
	     responseService.createResponse(inputResponseDto);
    }

//    @GetMapping("/instruction")
//    public InstructionView getInstruction(Long id){
//        return instructionService.getInstruction(id);
//    }

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

//    @GetMapping
//    @ResponseStatus(code = HttpStatus.OK)
//    public ForumView getForumView() {
//        Optional<Instruction> instruction = instructionService.get();
//        List<Response> response = responseService.getAllResponses();
//
//        return new ForumView(instruction.get(), response);
//    }
}
