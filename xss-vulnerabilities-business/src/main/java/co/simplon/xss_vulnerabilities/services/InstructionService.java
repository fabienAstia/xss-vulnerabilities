package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionUpdate;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;
import jakarta.persistence.EntityNotFoundException;

public class InstructionService {
    private final InstructionRepository repository;

    public InstructionService(InstructionRepository repository) {
	this.repository = repository;
    }

    public List<Instruction> getAllInstructions() {
	return repository.findAllProjectedBy();
    }

    public Instruction createInstruction(InstructionCreate dto) {
	Instruction instruction = new Instruction();
	instruction.setName(dto.name());
	return repository.save(instruction);
    }

    public void updateInstruction(InstructionUpdate dto) {
	Instruction instruction = repository.findById(1L)
		.orElseThrow(() -> new EntityNotFoundException("Instruction not found"));
	instruction.setName(dto.name());
	repository.save(instruction);
    }

}
