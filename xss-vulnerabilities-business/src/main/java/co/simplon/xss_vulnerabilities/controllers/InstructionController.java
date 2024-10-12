package co.simplon.xss_vulnerabilities.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.InstructionUpdate;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.services.InstructionService;

@RestController
@RequestMapping("/instruction")
@CrossOrigin("*")
public class InstructionController {

    private final InstructionService service;

    public InstructionController(InstructionService service) {
	this.service = service;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Instruction> get() {
	return service.get();
    }

    @PutMapping("/instruction")
    @ResponseStatus(code = HttpStatus.OK)
    public InstructionUpdate putMethodName(@RequestBody InstructionUpdate dto) {
	return service.updateInstruction(dto);
    }
}
