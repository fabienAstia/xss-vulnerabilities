package co.simplon.xss_vulnerabilities.repositories;

import co.simplon.xss_vulnerabilities.dtos.InstructionCreate;
import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {

//    List<Instruction> findAllProjectedBy();
    List<InstructionView> findAllProjectedBy();
    InstructionView findProjectedById(Long id);
}
