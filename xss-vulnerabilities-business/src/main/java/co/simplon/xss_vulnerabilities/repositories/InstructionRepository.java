package co.simplon.xss_vulnerabilities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.xss_vulnerabilities.dtos.InstructionView;
import co.simplon.xss_vulnerabilities.entities.Instruction;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

    /**
     * @return all instructions
     */
    List<InstructionView> findAllProjectedByOrderById();

    /**
     * @return last instruction
     */
    InstructionView findTopByOrderByIdDesc();
}
