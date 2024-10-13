package co.simplon.xss_vulnerabilities.services;

import java.util.List;
import java.util.Optional;

import co.simplon.xss_vulnerabilities.dtos.InstructionView;
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

    public InstructionView getInstruction(Long id) {
		return repository.findProjectedById(id);
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

	public List<InstructionView> getAllInstructions() {
		return repository.findAllProjectedBy();
	}

	public InstructionView getOneInstruction(Long id) {
		return repository.findProjectedById(id);
	}
}
