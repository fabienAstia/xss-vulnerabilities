package co.simplon.xss_vulnerabilities.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionUpdate;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructionService {
    private final InstructionRepository repository;

    public InstructionService(InstructionRepository repository) {
	this.repository = repository;
    }

    /*
     * public List<Instruction> getAllInstructions() { return
     * repository.findAllProjectedBy(); }
     */

    public Optional<Instruction> get() {
	return repository.findById(1L);
    }

    public Instruction createInstruction(InstructionCreate dto) {
	Instruction instruction = new Instruction();
	instruction.setName(dto.name());
	return repository.save(instruction);
    }

    public InstructionUpdate updateInstruction(InstructionUpdate dto) {
	Instruction instruction = repository.findById(1L)
		.orElseThrow(() -> new EntityNotFoundException("Instruction not found"));
	instruction.setName(dto.name());
	repository.save(instruction);
	return dto;
    }

}
