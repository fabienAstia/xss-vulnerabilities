package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionUpdate;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;

public class InstructionService {
    private final InstructionRepository repository;

    public InstructionService(InstructionRepository repository) {
	this.repository = repository;
    }

    public List<Instruction> getAllInstructions() {
	return repository.findAllProjectedBy();
    }

    public Instruction createInstruction(InstructionCreate instructionCreate) {
	Instruction instruction = new Instruction();
	instruction.setName(instructionCreate.name());
	return repository.save(instruction);
    }

    public void updateInstruction(Long id, InstructionUpdate inputs) {
	return;
    }

}
