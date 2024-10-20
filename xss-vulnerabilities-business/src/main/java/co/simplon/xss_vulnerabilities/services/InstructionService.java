package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;

@Service
public class InstructionService {

    private final InstructionRepository repository;

    public InstructionService(InstructionRepository repository) {
	this.repository = repository;
    }

    public Instruction createInstruction(InstructionCreate dto) {
	Instruction instruction = new Instruction();
	instruction.setName(dto.name());
	return repository.save(instruction);
    }

    public List<InstructionView> getAllInstructions() {
	return repository.findAllProjectedByOrderById();
    }

    public InstructionView getLastInstruction() {
	return repository.findTopByOrderByIdDesc();
    }

}
