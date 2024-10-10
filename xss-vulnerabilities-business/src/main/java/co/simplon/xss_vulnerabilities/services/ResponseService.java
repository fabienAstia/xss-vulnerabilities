package co.simplon.xss_vulnerabilities.services;

import co.simplon.xss_vulnerabilities.dtos.InputResponseDto;
import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.entities.Response;
import co.simplon.xss_vulnerabilities.repositories.InstructionRepository;
import co.simplon.xss_vulnerabilities.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    private final InstructionRepository instructionRepository;
    private final ResponseRepository responseRepository;

    public ResponseService(InstructionRepository instructionRepository, ResponseRepository responseRepository) {
        this.instructionRepository = instructionRepository;
        this.responseRepository = responseRepository;
    }

    public List<Response> getAllResponses() {
        return responseRepository.findAllProjectedBy();
    }

    public List<Instruction> getAllInstructions() {
        return instructionRepository.findAllProjectedBy();
    }

    public Response createResponse(InputResponseDto inputResponseDto) {
        Response response = new Response();
        response.setFirstname(inputResponseDto.name());
        response.setResult(inputResponseDto.response());
        return responseRepository.save(response);
    }

}
